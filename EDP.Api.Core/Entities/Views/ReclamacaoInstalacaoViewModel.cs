using System;
using System.Collections.Generic;
using System.Text;

namespace EDP.Api.Core.Entities.Views
{
    public class ReclamacaoInstalacaoViewModel
    {
        ///<summary>
        /// V_CODIGOCLIENTE
        ///</summary>
        public int CodigoCliente{get;set;}
        
        ///<summary>
        /// V_CODIGOINSTALACAO
        ///</summary>
        public int CodigoInstalacao{get;set;}

        ///<summary>
        /// V_CODIGOREGIAO
        ///</summary>
        public int CodigoRegiao{get;set;}

        ///<summary>
        /// V_STATUS
        ///</summary>
        public string Status {get;set;}

        ///<summary>
        /// V_DATACADASTRO
        ///</summary>
        public DateTime DataCadastro {get;set;}

        ///<summary>
        /// V_DESCRICAOOPCIONAL
        ///</summary>
        public string DescricaoOpcional {get;set;}
    }
}
