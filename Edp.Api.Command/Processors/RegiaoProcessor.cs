﻿using Edp.Api.Database;
using EDP.Api.Core.Configuration;
using EDP.Api.Core.Entities.Views;
using EDP.Api.Core.Entities.Models;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Text;

namespace Edp.Api.Command.Processors
{
    public class RegiaoProcessor : Processor
    {
        public RegiaoProcessor(String connection, MyOptions _myOptions) : base(connection, _myOptions)
        {
        }

        public async System.Threading.Tasks.Task<object> GetRegiaoAsync(int id)
        {
            try
            {
                List<Regiao> result = await DbControl.ExecuteProcWithReturnAsync<ReclamacaoInstalacao>(
                    StoredProcedure.GetRegiao,
                    new OracleCommand());
                return result;
            }
            catch (Exception x)
            {
                //TODO: Adicionar log para Exception
                return new HttpResponseMessage(System.Net.HttpStatusCode.ExpectationFailed);
            }
        }

        public async System.Threading.Tasks.Task<object> PostRegiaoAsync(RegiaoViewModel viewModel)
        {
            try
            {
                //TODO: Corrigir para realmente funcionar e inserir no banco
                var result = await DbControl.ExecuteProcWithReturnAsync(
                    StoredProcedure.InsertRegiao,
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
