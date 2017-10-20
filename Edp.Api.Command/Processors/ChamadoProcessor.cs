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
                //TODO: Corrigir para realmente funcionar e inserir no banco
                var result = await DbControl.ExecuteProcWithReturnAsync(
                    StoredProcedure.InsertChamado,
                    new OracleCommand());
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
