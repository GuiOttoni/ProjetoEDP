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
    public class InstalacaoProcessor : Processor
    {
        public InstalacaoProcessor(String connection, MyOptions _myOptions) : base(connection, _myOptions)
        {
        }

        public async System.Threading.Tasks.Task<object> PostInstalacaoAsync(InstalacaoViewModel viewModel)
        {
            try
            {
                OracleCommand orcCommand = new OracleCommand();
                
                orcCommand.Parameters.add(new OracleParameter("V_CODIGO_CLIENTE", viewModel.CodigoCliente));
                orcCommand.Parameters.add(new OracleParameter("V_CODIGO_REGIAO", viewModel.CodigoRegiao));

                var result = await DbControl.ExecuteProcWithReturnAsync(
                    StoredProcedure.InsertInstalacao,
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
