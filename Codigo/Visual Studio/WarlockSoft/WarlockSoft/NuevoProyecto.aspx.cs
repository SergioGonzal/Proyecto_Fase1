using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class NuevoProyecto : System.Web.UI.Page
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

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (txtNombre.Text != "" & txtInicio.Text != "" & txtFin.Text != "")
            {
                WS_CrearProyecto.CrearProyecto CP = new WS_CrearProyecto.CrearProyecto();
                
                CP.GuardarProyecto(txtNombre.Text, txtInicio.Text, txtFin.Text, ID);
                String IDp = CP.ObtenerIDProyecto(txtNombre.Text);

                Response.Redirect("TareaProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Campos Vacios')");
                Response.Write("</script>");
            }
        }
    }
}