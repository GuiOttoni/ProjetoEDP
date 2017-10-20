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
    public class ClienteController : Controller
    {
        #region Var
        /// <summary>
        /// Variavel para acessar opções do appsettings.json
        /// </summary>
        private readonly MyOptions _options;

        /// <summary>
        /// variavel do processor do controller
        /// </summary>
        private ClienteProcessor processor;
        #endregion

        #region Constructor
        /// <summary>
        /// 
        /// </summary>
        /// <param name="optionsAccessor"></param>
        public ClienteController(Microsoft.Extensions.Options.IOptions<MyOptions> optionsAccessor)
        {
            _options = optionsAccessor.Value;
            Processor = new ClienteProcessor(_options.ConnectionString, _options);
        }
        #endregion

        #region Public Methods

        [Route("api/cliente/new")]
        [HttpPost]
        public async Task<IActionResult> PostAsync([FromBody]ClienteViewModel viewModel)
        {
            return Json(await processor.PostClienteAsync(viewModel));
        }
        #endregion

    }
}
