using Edp.Api.Database;
using EDP.Api.Core.Configuration;
using EDP.Api.Core.Entities.Views;
using EDP.Api.Core.Entities.Models;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;

namespace Edp.Api.Command.Processors
{
    public class ReclamacaoInstalacaoProcessor : Processor
    {
        public ReclamacaoInstalacaoProcessor(String connection, MyOptions _myOptions) : base(connection, _myOptions)
        {
        }

        public async System.Threading.Tasks.Task<object> PostReclamacaoAsync(ReclamacaoInstalacaoViewModel viewModel)
        {
            try
            {
                OracleCommand orcCommand = new OracleCommand();

                orcCommand.Parameters.add(new OracleParameter("V_CODIGOCLIENTE", viewModel.CodigoCliente));
                orcCommand.Parameters.add(new OracleParameter("V_CODIGOINSTALACAO", viewModel.CodigoInstalacao));
                orcCommand.Parameters.add(new OracleParameter("V_CODIGOREGIAO", viewModel.CodigoRegiao));
                orcCommand.Parameters.add(new OracleParameter("V_DATACADASTRO", viewModel.DataCadastro));
                orcCommand.Parameters.add(new OracleParameter("V_DESCRICAOOPCIONAL", viewModel.DescricaoOpcional));
                orcCommand.Parameters.add(new OracleParameter("V_STATUS", viewModel.Status));

                var result = await DbControl.ExecuteProcWithReturnAsync(
                    StoredProcedure.InsertReclamacaoInstalacao, 
                    orcCommand);
                return result;
            }
            catch (Exception x)
            {
                //TODO: Adicionar log para Exception
                return new HttpResponseMessage(System.Net.HttpStatusCode.ExpectationFailed);
            }
        }

        public async System.Threading.Tasks.Task<object> GetReclamacaoAsync()
        {
            try
            {
                //TODO: Fazer proc
                List<ReclamacaoInstalacao> result = await DbControl.ExecuteProcWithReturnAsync<ReclamacaoInstalacao>(
                    StoredProcedure.GetReclamacaoInstalacao,
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
