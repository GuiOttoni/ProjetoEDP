using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using EDP.Api.Core.Configuration;
using Edp.Api.Command.Processors;
using EDP.Api.Core.Entities.Views;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ProjetoEDP.Controllers
{
    public class ReclamacaoInstalacaoController : Controller
    {
        #region Var
        private readonly MyOptions _options;
        private ReclamacaoInstalacaoProcessor processor;
        #endregion

        #region Constructor
        public ReclamacaoInstalacaoController(Microsoft.Extensions.Options.IOptions<MyOptions> optionsAccessor)
        {
            _options = optionsAccessor.Value;
            Processor = new ReclamacaoInstalacaoProcessor(_options.ConnectionString, _options);
        }
        #endregion

        #region Public Methods
        /// <summary>
        /// 
        /// </summary>
        /// <param name="viewModel"></param>
        /// <returns></returns>
        [Route("api/reclamacao/get")]
        [HttpGet]
        public async Task<IActionResult> GetAsync([FromBody]ReclamacaoInstalacaoViewModel viewModel)
        {
            return Json(await processor.GetReclamacaoAsync(viewModel));
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="viewModel"></param>
        /// <returns></returns>
        [Route("api/reclamacao/post")]
        [HttpPost]
        public async Task<IActionResult> PostAsync([FromBody]ReclamacaoInstalacaoViewModel viewModel)
        {
            return Json(await processor.PostReclamacaoAsync(viewModel));
        }
        #endregion
    }
}
