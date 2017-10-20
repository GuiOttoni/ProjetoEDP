using System;
using System.Collections.Generic;
using System.Text;

namespace EDP.Api.Core.Entities.Views
{
    public class ClienteViewModel
    {

        /// <summary>
        /// V_NOME
        /// </summary>
        public string Nome {get;set;}

        /// <summary>
        /// V_SOBRENOME
        /// </summary>
        public string Sobrenome {get;set;}

        /// <summary>
        /// V_DATANASCIMENTO
        /// </summary>
        public DateTime DataNascimento {get;set;}

        /// <summary>
        /// V_ENDERECO
        /// </summary>       
        public string Endereco {get;set;}

        /// <summary>
        /// V_CEP
        /// </summary>              
        public string CEP {get;set;}

        /// <summary>
        /// V_CIDADE
        /// </summary>
        public string Cidade {get;set;}        
                
        /// <summary>
        /// V_ESTADO
        /// </summary> 
        public string Estado {get;set;}
    }
}
