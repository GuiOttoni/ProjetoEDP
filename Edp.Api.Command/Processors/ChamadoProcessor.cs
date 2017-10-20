using Edp.Api.Database;
using EDP.Api.Core.Configuration;
using EDP.Api.Core.Entities.Views;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;

namespace Edp.Api.Command.Processors
{
    public class ChamadoProcessor : Processor
    {
        public ChamadoProcessor(String connection, MyOptions _myOptions) : base(connection, _myOptions)
        {
        }

        public async System.Threading.Tasks.Task<object> PostChamadoAsync(ChamadoViewModel viewModel)
        {
            try
            {
                OracleCommand orcCommand = new OracleCommand();
                
                orcCommand.Parameters.Add(new OracleParameter("V_CODIGO_CLIENTE", viewModel.CodigoCliente));
                orcCommand.Parameters.Add(new OracleParameter("V_CODIGO_REGIAO", viewModel.CodigoRegiao));
                orcCommand.Parameters.Add(new OracleParameter("V_DESCRICAO", viewModel.Descricao));
                
                var result = await DbControl.ExecuteProcWithReturnAsync(
                    StoredProcedure.InsertChamado,
                    orcCommand);
                return result;
            }
            catch (Exception x)
            {
                //TODO: Adicionar log para Exception
                return new HttpResponseMessage(System.Net.HttpStatusCode.ExpectationFailed);
            }
        }

    }
}
