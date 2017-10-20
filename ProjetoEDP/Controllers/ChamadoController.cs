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
    public class ChamadoController : Controller
    {
        #region Var
        /// <summary>
        /// Variavel para acessar opções do appsettings.json
        /// </summary>
        private readonly MyOptions _options;

        /// <summary>
        /// variavel do processor do controller
        /// </summary>
        private ChamadoProcessor processor;
        #endregion

        #region Constructor
        /// <summary>
        /// 
        /// </summary>
        /// <param name="optionsAccessor"></param>
        public ChamadoController(Microsoft.Extensions.Options.IOptions<MyOptions> optionsAccessor)
        {
            _options = optionsAccessor.Value;
            Processor = new ChamadoProcessor(_options.ConnectionString, _options);
        }
        #endregion

        #region Public Methods

        [Route("api/chamado/new")]
        [HttpPost]
        public async Task<IActionResult> PostAsync([FromBody]ChamadoViewModel viewModel)
        {
            return Json(await processor.PostChamadoAsync(viewModel));
        }
        #endregion

    }
}
