using EDP.Api.Core.Configuration;
using System;
using System.Collections.Generic;
using System.Text;

namespace Edp.Api.Command.Processors
{
    public class InstalacaoProcessor : Processor
    {
        public InstalacaoProcessor(String connection, MyOptions _myOptions) : base(connection, _myOptions)
        {
        }
    }
}
