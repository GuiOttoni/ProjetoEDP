using System;
using System.Collections.Generic;
using System.Text;

namespace EDP.Api.Core.Entities.Views
{
    public class ReclamacaoInstalacaoViewModel
    {
        //V_CODIGOCLIENTE
        public int CodigoCliente{get;set;}
        
	    //V_CODIGOINSTALACAO
        public int CodigoInstalacao{get;set;}

	    //V_CODIGOREGIAO
        public int CodigoRegiao{get;set;}

	    //V_STATUS
        public string Status {get;set;}

	    //V_DATACADASTRO
        public DateTime DataCadastro {get;set;}

	    //V_DESCRICAOOPCIONAL
        public string DescricaoOpcional {get;set;}
    }
}
