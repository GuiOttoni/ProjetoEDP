using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Edp.Api.Command.Processors;
using EDP.Api.Core.Configuration;
using EDP.Api.Core.Entities.Views;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ProjetoEDP.Controllers
{
    public class RegiaoController : Controller
    {
        #region Var
        /// <summary>
        /// Variavel para acessar opções do appsettings.json
        /// </summary>
        private readonly MyOptions _options;

        /// <summary>
        /// variavel do processor do controller
        /// </summary>
        private RegiaoProcessor processor;
        #endregion

        #region Constructor
        /// <summary>
        /// 
        /// </summary>
        /// <param name="optionsAccessor"></param>
        public RegiaoController(Microsoft.Extensions.Options.IOptions<MyOptions> optionsAccessor)
        {
            _options = optionsAccessor.Value;
            Processor = new RegiaoProcessor(_options.ConnectionString, _options);
        }
        #endregion

        #region Public Methods
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        [HttpGet]
        [Route("api/regiao/get")]
        public async Task<IActionResult> GetAsync()
        {
            return Json(await processor.GetRegiaoAsync());
        }

        [HttpPost]
        [Route("api/regiao/post")]
        public async Task<IActionResult> GetAsync([FromBody]RegiaoViewModel viewModel)
        {
            return Json(await processor.PostRegiaoAsync(viewModel));
        }
        #endregion
    }
}
