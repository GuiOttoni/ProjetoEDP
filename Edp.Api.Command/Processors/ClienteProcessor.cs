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
    public class ClienteProcessor : Processor
    {
        public ClienteProcessor(String connection, MyOptions _myOptions) : base(connection, _myOptions)
        {
        }

        public async System.Threading.Tasks.Task<object> PostClienteAsync(ClienteViewModel viewModel)
        {
            try
            {
                OracleCommand orcCommand = new OracleCommand();

                orcCommand.Parameters.add(new OracleParameter("V_CEP", viewModel.CEP));
                orcCommand.Parameters.add(new OracleParameter("V_CIDADE", viewModel.Cidade));
                orcCommand.Parameters.add(new OracleParameter("V_DATANASCIMENTO", viewModel.DataNascimento));
                orcCommand.Parameters.add(new OracleParameter("V_ENDERECO", viewModel.Endereco));
                orcCommand.Parameters.add(new OracleParameter("V_ESTADO", viewModel.Estado));
                orcCommand.Parameters.add(new OracleParameter("V_NOME", viewModel.Nome));
                orcCommand.Parameters.add(new OracleParameter("V_SOBRENOME", viewModel.Sobrenome));

                var result = await DbControl.ExecuteProcWithReturnAsync(
                    StoredProcedure.InsertCliente,
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
