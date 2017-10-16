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
                //TODO: Conectar com o banco e fazer o insert
                var result = await DbControl.ExecuteProcWithReturnAsync(
                    StoredProcedure.InsertReclamacaoInstalacao, 
                    new OracleCommand());
                return result;
            }
            catch (Exception x)
            {
                //TODO: Adicionar log para Exception
                return new HttpResponseMessage(System.Net.HttpStatusCode.ExpectationFailed);
            }
        }

        public async System.Threading.Tasks.Task<object> GetReclamacaoAsync(ReclamacaoInstalacaoViewModel viewModel)
        {
            try
            {
                //TODO: Conectar com o banco e fazer o insert
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
