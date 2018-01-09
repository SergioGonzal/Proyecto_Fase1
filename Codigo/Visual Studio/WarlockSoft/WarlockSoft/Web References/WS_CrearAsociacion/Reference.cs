﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// Microsoft.VSDesigner generó automáticamente este código fuente, versión=4.0.30319.42000.
// 
#pragma warning disable 1591

namespace WarlockSoft.WS_CrearAsociacion {
    using System;
    using System.Web.Services;
    using System.Diagnostics;
    using System.Web.Services.Protocols;
    using System.Xml.Serialization;
    using System.ComponentModel;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="CrearAsociacionPortBinding", Namespace="http://WarlockSoft/")]
    public partial class CrearAsociacion : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback CreaAsociacionOperationCompleted;
        
        private System.Threading.SendOrPostCallback ObtenerIDAsociacionOperationCompleted;
        
        private System.Threading.SendOrPostCallback ObtenerAsociacionesOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public CrearAsociacion() {
            this.Url = global::WarlockSoft.Properties.Settings.Default.WarlockSoft_WS_CrearAsociacion_CrearAsociacion;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event CreaAsociacionCompletedEventHandler CreaAsociacionCompleted;
        
        /// <remarks/>
        public event ObtenerIDAsociacionCompletedEventHandler ObtenerIDAsociacionCompleted;
        
        /// <remarks/>
        public event ObtenerAsociacionesCompletedEventHandler ObtenerAsociacionesCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://WarlockSoft/", ResponseNamespace="http://WarlockSoft/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool CreaAsociacion([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string NombreAs, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string Objetivo, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string IDUsuario) {
            object[] results = this.Invoke("CreaAsociacion", new object[] {
                        NombreAs,
                        Objetivo,
                        IDUsuario});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void CreaAsociacionAsync(string NombreAs, string Objetivo, string IDUsuario) {
            this.CreaAsociacionAsync(NombreAs, Objetivo, IDUsuario, null);
        }
        
        /// <remarks/>
        public void CreaAsociacionAsync(string NombreAs, string Objetivo, string IDUsuario, object userState) {
            if ((this.CreaAsociacionOperationCompleted == null)) {
                this.CreaAsociacionOperationCompleted = new System.Threading.SendOrPostCallback(this.OnCreaAsociacionOperationCompleted);
            }
            this.InvokeAsync("CreaAsociacion", new object[] {
                        NombreAs,
                        Objetivo,
                        IDUsuario}, this.CreaAsociacionOperationCompleted, userState);
        }
        
        private void OnCreaAsociacionOperationCompleted(object arg) {
            if ((this.CreaAsociacionCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.CreaAsociacionCompleted(this, new CreaAsociacionCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://WarlockSoft/", ResponseNamespace="http://WarlockSoft/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string ObtenerIDAsociacion([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string NombreProy) {
            object[] results = this.Invoke("ObtenerIDAsociacion", new object[] {
                        NombreProy});
            return ((string)(results[0]));
        }
        
        /// <remarks/>
        public void ObtenerIDAsociacionAsync(string NombreProy) {
            this.ObtenerIDAsociacionAsync(NombreProy, null);
        }
        
        /// <remarks/>
        public void ObtenerIDAsociacionAsync(string NombreProy, object userState) {
            if ((this.ObtenerIDAsociacionOperationCompleted == null)) {
                this.ObtenerIDAsociacionOperationCompleted = new System.Threading.SendOrPostCallback(this.OnObtenerIDAsociacionOperationCompleted);
            }
            this.InvokeAsync("ObtenerIDAsociacion", new object[] {
                        NombreProy}, this.ObtenerIDAsociacionOperationCompleted, userState);
        }
        
        private void OnObtenerIDAsociacionOperationCompleted(object arg) {
            if ((this.ObtenerIDAsociacionCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.ObtenerIDAsociacionCompleted(this, new ObtenerIDAsociacionCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://WarlockSoft/", ResponseNamespace="http://WarlockSoft/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true)]
        public string[] ObtenerAsociaciones([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string IDUsuario) {
            object[] results = this.Invoke("ObtenerAsociaciones", new object[] {
                        IDUsuario});
            return ((string[])(results[0]));
        }
        
        /// <remarks/>
        public void ObtenerAsociacionesAsync(string IDUsuario) {
            this.ObtenerAsociacionesAsync(IDUsuario, null);
        }
        
        /// <remarks/>
        public void ObtenerAsociacionesAsync(string IDUsuario, object userState) {
            if ((this.ObtenerAsociacionesOperationCompleted == null)) {
                this.ObtenerAsociacionesOperationCompleted = new System.Threading.SendOrPostCallback(this.OnObtenerAsociacionesOperationCompleted);
            }
            this.InvokeAsync("ObtenerAsociaciones", new object[] {
                        IDUsuario}, this.ObtenerAsociacionesOperationCompleted, userState);
        }
        
        private void OnObtenerAsociacionesOperationCompleted(object arg) {
            if ((this.ObtenerAsociacionesCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.ObtenerAsociacionesCompleted(this, new ObtenerAsociacionesCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    public delegate void CreaAsociacionCompletedEventHandler(object sender, CreaAsociacionCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class CreaAsociacionCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal CreaAsociacionCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public bool Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bool)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    public delegate void ObtenerIDAsociacionCompletedEventHandler(object sender, ObtenerIDAsociacionCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class ObtenerIDAsociacionCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal ObtenerIDAsociacionCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public string Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((string)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    public delegate void ObtenerAsociacionesCompletedEventHandler(object sender, ObtenerAsociacionesCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class ObtenerAsociacionesCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal ObtenerAsociacionesCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public string[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((string[])(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591