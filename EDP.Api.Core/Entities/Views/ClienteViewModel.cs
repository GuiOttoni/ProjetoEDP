using System;
using System.Collections.Generic;
using System.Text;

namespace EDP.Api.Core.Entities.Views
{
    public class ClienteViewModel
    {
        //V_NOME
        public string Nome {get;set;}

    	//V_SOBRENOME
        public string Sobrenome {get;set;}

    	//V_DATANASCIMENTO      
        public DateTime DataNascimento {get;set;}

    	//V_ENDERECO           
        public string Endereco {get;set;}

    	//V_CEP                   
        public string CEP {get;set;}

    	//V_CIDADE
        public string Cidade {get;set;}        
                
    	//V_ESTADO    
        public string Estado {get;set;}
    }
}
