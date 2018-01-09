using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class CargaMasiva : System.Web.UI.Page
    {
        new String ID = "";

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnCargar_Click(object sender, EventArgs e)
        {
            if (rbtnCargas.SelectedIndex == 0)
            {
                WS_CargarUsuariosAsociaciones.AdminIngresarUsuarioAsociacion CUA = new WS_CargarUsuariosAsociaciones.AdminIngresarUsuarioAsociacion();
                CUA.AgregarUyA(txtCarga.Text);

                Response.Redirect("CargaMasiva.aspx?ID=" + ID);
            }
            else if (rbtnCargas.SelectedIndex == 1)
            {
                WS_CargaEstadosComentarios.AdminIngresarEstadoComentario CEC = new WS_CargaEstadosComentarios.AdminIngresarEstadoComentario();
                CEC.AgregarEyC(txtCarga.Text);

                Response.Redirect("CargaMasiva.aspx?ID=" + ID);
            }
            else if (rbtnCargas.SelectedIndex == 2)
            {
                WS_CargarProyectos.AdminIngresarProyecto CP = new WS_CargarProyectos.AdminIngresarProyecto();
                CP.AgregarP(txtCarga.Text);

                Response.Redirect("CargaMasiva.aspx?ID=" + ID);
            }
            else if (rbtnCargas.SelectedIndex == 3)
            {

                Response.Redirect("CargaMasiva.aspx?ID=" + ID);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Seleccione una opción!')");
                Response.Write("</script>");
            }
            
        }
    }
}