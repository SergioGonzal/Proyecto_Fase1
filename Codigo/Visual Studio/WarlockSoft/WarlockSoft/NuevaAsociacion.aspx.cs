using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class NuevaAsociacion : System.Web.UI.Page
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

        protected void btnCrear_Click(object sender, EventArgs e)
        {
            WS_CrearAsociacion.CrearAsociacion CA = new WS_CrearAsociacion.CrearAsociacion();

            if (txtNombreAs.Text!="" & txtObjetivo.Text!= "")
            {
                CA.CreaAsociacion(txtNombreAs.Text, txtObjetivo.Text, ID);

                Response.Redirect("MisAsociaciones.aspx?ID=" + ID);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Campos Vacios!')");
                Response.Write("</script>");
            }
            
        }
    }
}