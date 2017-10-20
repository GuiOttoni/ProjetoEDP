using Edp.Api.Command.Util;
using Edp.Api.Database;
using EDP.Api.Core.Configuration;
using System;
using System.Collections.Generic;
using System.Text;

namespace Edp.Api.Command
{
    public class Processor
    {
        protected DatabaseControl DbControl;
        protected RestExecutor restExecutor;
        protected MyOptions myOptions;

        public Processor(string connection, MyOptions _myOptions)
        {
            DbControl = new DatabaseControl(connection);
            restExecutor = new RestExecutor();
            myOptions = _myOptions;
        }
    }
}
