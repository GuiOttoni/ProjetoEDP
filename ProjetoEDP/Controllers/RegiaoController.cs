using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Edp.Api.Command.Processors;
using EDP.Api.Core.Configuration;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ProjetoEDP.Controllers
{
    [Route("api/[controller]")]
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
        private RegiaoProcessor Processor;
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
        public async Task<IActionResult> Get(int id)
        {
            return Json("");
        }
        #endregion
    }
}
