using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Data.Common;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Edp.Api.Database
{
    public class DatabaseControl
    {
        private String connectionString = "";

        public DatabaseControl(string connection)
        {
            this.connectionString = connection;
        }

        /// <summary>
        /// Retorna uma lista de um objeto T
        /// Pode retornar uma lista com 1 só informação
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="Proc"></param>
        /// <param name="cmd"></param>
        /// <returns></returns>
        public async Task<List<T>> ExecuteProcWithReturnAsync<T>(string Proc, OracleCommand cmd) where T : new()
        {
            List<T> result = new List<T>();
            try
            {
                using (var conn = new OracleConnection(connectionString))
                {

                    using (var command = new OracleCommand(Proc, conn)
                    {
                        CommandType = System.Data.CommandType.StoredProcedure
                    })

                    {
                        foreach (var param in cmd.Parameters)
                        {
                            command.Parameters.Add(param);
                        }
                        conn.Open();
                        using (var reader = await command.ExecuteReaderAsync())
                        {
                            result = Map<T>(reader);
                        }
                    }
                }
            }
            catch (Exception x)
            {

            }
            finally
            {

            }
            return result;
        }

        public async Task<object> ExecuteProcWithReturnAsync(string Proc, OracleCommand cmd)
        {
            object returnObject = null;
            List<object> resultObjectList = new List<object>();
            List<List<object>> resultListOfObjects = new List<List<object>>();
            try
            {
                using (var conn = new OracleConnection(connectionString))
                {

                    using (var command = new OracleCommand(Proc, conn)
                    {
                        CommandType = System.Data.CommandType.StoredProcedure
                    })
                    {
                        foreach (var param in cmd.Parameters)
                        {
                            command.Parameters.Add(param);
                        }
                        conn.Open();
                        using (var reader = await command.ExecuteReaderAsync())
                        {

                        }
                    }
                }
            }
            catch (Exception x)
            {

            }
            finally
            {

            }
            return null;
        }

        /// <summary>
        /// Mapper para fazer o de para dos objetos
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="dr"></param>
        /// <returns></returns>
        private List<T> Map<T>(DbDataReader dr) where T : new()
        {
            if (dr != null)
            {
                var entity = typeof(T);
                var entities = new List<T>();
                var propDict = new Dictionary<String, PropertyInfo>();
                var props = entity.GetProperties(BindingFlags.Instance | BindingFlags.Public);
                propDict = props.ToDictionary(p => p.Name.ToUpper(), p => p);

                while (dr.Read())
                {
                    T newObject = new T();
                    for (int index = 0; index < dr.FieldCount; index++)
                    {
                        if (propDict.ContainsKey(dr.GetName(index).ToUpper()))
                        {
                            var info = propDict[dr.GetName(index).ToUpper()];
                            if ((info != null) && info.CanWrite)
                            {
                                var val = dr.GetValue(index);
                                info.SetValue(newObject, (val == DBNull.Value) ? null : val, null);
                            }
                        }
                    }
                    entities.Add(newObject);
                }
                return entities;
            }
            return null;
        }

        /// <summary>
        /// Executa stored procedure 
        /// </summary>
        public void ExecuteProcWithNoReturn()
        {
            try
            {
                using (var conn = new OracleConnection(""))
                {
                    conn.Open();
                }
            }
            catch (Exception x)
            {

            }
            finally
            {

            }
        }

    }
}
