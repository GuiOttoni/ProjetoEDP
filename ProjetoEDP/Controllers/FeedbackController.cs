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
    [Route("api/[controller]")]
    public class FeedbackController : Controller
    {
        #region Var
        /// <summary>
        /// Variavel para acessar opções do appsettings.json
        /// </summary>
        private readonly MyOptions _options;

        /// <summary>
        /// variavel do processor do controller
        /// </summary>
        private FeedbackProcessor processor;
        #endregion

        #region Constructor
        /// <summary>
        /// 
        /// </summary>
        /// <param name="optionsAccessor"></param>
        public FeedbackController(Microsoft.Extensions.Options.IOptions<MyOptions> optionsAccessor)
        {
            _options = optionsAccessor.Value;
            Processor = new FeedbackProcessor(_options.ConnectionString, _options);
        }
        #endregion

        #region Public Methods

        [Route("api/feedback/new")]
        [HttpPost]
        public async Task<IActionResult> PostAsync([FromBody]FeedbackViewModel viewModel)
        {
            return Json(await processor.PostFeedbackAsync(viewModel));
        }
        #endregion

    }
}
