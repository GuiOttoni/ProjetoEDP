using EDP.Api.Core.Configuration;
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
    }
}
