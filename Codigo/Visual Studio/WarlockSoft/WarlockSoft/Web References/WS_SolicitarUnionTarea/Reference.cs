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

namespace WarlockSoft.WS_SolicitarUnionTarea {
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
    [System.Web.Services.WebServiceBindingAttribute(Name="SolicitarUnionTareaPortBinding", Namespace="http://WarlockSoft/")]
    public partial class SolicitarUnionTarea : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback TerminarTareaOperationCompleted;
        
        private System.Threading.SendOrPostCallback SolicitarTrabajarTareaOperationCompleted;
        
        private System.Threading.SendOrPostCallback ObtenerDatosTareaOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public SolicitarUnionTarea() {
            this.Url = global::WarlockSoft.Properties.Settings.Default.WarlockSoft_WS_SolicitarUnionTarea_SolicitarUnionTarea;
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
        public event TerminarTareaCompletedEventHandler TerminarTareaCompleted;
        
        /// <remarks/>
        public event SolicitarTrabajarTareaCompletedEventHandler SolicitarTrabajarTareaCompleted;
        
        /// <remarks/>
        public event ObtenerDatosTareaCompletedEventHandler ObtenerDatosTareaCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://WarlockSoft/", ResponseNamespace="http://WarlockSoft/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool TerminarTarea([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string Tarea, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string IDProyecto) {
            object[] results = this.Invoke("TerminarTarea", new object[] {
                        Tarea,
                        IDProyecto});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void TerminarTareaAsync(string Tarea, string IDProyecto) {
            this.TerminarTareaAsync(Tarea, IDProyecto, null);
        }
        
        /// <remarks/>
        public void TerminarTareaAsync(string Tarea, string IDProyecto, object userState) {
            if ((this.TerminarTareaOperationCompleted == null)) {
                this.TerminarTareaOperationCompleted = new System.Threading.SendOrPostCallback(this.OnTerminarTareaOperationCompleted);
            }
            this.InvokeAsync("TerminarTarea", new object[] {
                        Tarea,
                        IDProyecto}, this.TerminarTareaOperationCompleted, userState);
        }
        
        private void OnTerminarTareaOperationCompleted(object arg) {
            if ((this.TerminarTareaCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.TerminarTareaCompleted(this, new TerminarTareaCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://WarlockSoft/", ResponseNamespace="http://WarlockSoft/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool SolicitarTrabajarTarea([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string Tarea, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string IDUsuario, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string IDProyecto) {
            object[] results = this.Invoke("SolicitarTrabajarTarea", new object[] {
                        Tarea,
                        IDUsuario,
                        IDProyecto});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void SolicitarTrabajarTareaAsync(string Tarea, string IDUsuario, string IDProyecto) {
            this.SolicitarTrabajarTareaAsync(Tarea, IDUsuario, IDProyecto, null);
        }
        
        /// <remarks/>
        public void SolicitarTrabajarTareaAsync(string Tarea, string IDUsuario, string IDProyecto, object userState) {
            if ((this.SolicitarTrabajarTareaOperationCompleted == null)) {
                this.SolicitarTrabajarTareaOperationCompleted = new System.Threading.SendOrPostCallback(this.OnSolicitarTrabajarTareaOperationCompleted);
            }
            this.InvokeAsync("SolicitarTrabajarTarea", new object[] {
                        Tarea,
                        IDUsuario,
                        IDProyecto}, this.SolicitarTrabajarTareaOperationCompleted, userState);
        }
        
        private void OnSolicitarTrabajarTareaOperationCompleted(object arg) {
            if ((this.SolicitarTrabajarTareaCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.SolicitarTrabajarTareaCompleted(this, new SolicitarTrabajarTareaCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://WarlockSoft/", ResponseNamespace="http://WarlockSoft/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true)]
        public string[] ObtenerDatosTarea([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string IDProyecto, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string Tarea) {
            object[] results = this.Invoke("ObtenerDatosTarea", new object[] {
                        IDProyecto,
                        Tarea});
            return ((string[])(results[0]));
        }
        
        /// <remarks/>
        public void ObtenerDatosTareaAsync(string IDProyecto, string Tarea) {
            this.ObtenerDatosTareaAsync(IDProyecto, Tarea, null);
        }
        
        /// <remarks/>
        public void ObtenerDatosTareaAsync(string IDProyecto, string Tarea, object userState) {
            if ((this.ObtenerDatosTareaOperationCompleted == null)) {
                this.ObtenerDatosTareaOperationCompleted = new System.Threading.SendOrPostCallback(this.OnObtenerDatosTareaOperationCompleted);
            }
            this.InvokeAsync("ObtenerDatosTarea", new object[] {
                        IDProyecto,
                        Tarea}, this.ObtenerDatosTareaOperationCompleted, userState);
        }
        
        private void OnObtenerDatosTareaOperationCompleted(object arg) {
            if ((this.ObtenerDatosTareaCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.ObtenerDatosTareaCompleted(this, new ObtenerDatosTareaCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
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
    public delegate void TerminarTareaCompletedEventHandler(object sender, TerminarTareaCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class TerminarTareaCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal TerminarTareaCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
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
    public delegate void SolicitarTrabajarTareaCompletedEventHandler(object sender, SolicitarTrabajarTareaCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class SolicitarTrabajarTareaCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal SolicitarTrabajarTareaCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
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
    public delegate void ObtenerDatosTareaCompletedEventHandler(object sender, ObtenerDatosTareaCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2046.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class ObtenerDatosTareaCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal ObtenerDatosTareaCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
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