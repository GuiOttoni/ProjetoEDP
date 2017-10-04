using EDP.Api.Core.Configuration;
using System;
using System.Collections.Generic;
using System.Text;

namespace Edp.Api.Command.Processors
{
    public class ChamadoProcessor : Processor
    {
        public ChamadoProcessor(String connection, MyOptions _myOptions) : base(connection, _myOptions)
        {
        }
    }
}
