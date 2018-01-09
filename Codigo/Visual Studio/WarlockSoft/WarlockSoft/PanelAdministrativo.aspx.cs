using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class PanelAdministrativo : System.Web.UI.Page
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

        protected void btnCarga_Click(object sender, EventArgs e)
        {
            Response.Redirect("CargaMasiva.aspx?ID=" + ID);
        }

        protected void btnDenuncias_Click(object sender, EventArgs e)
        {
            Response.Redirect("Denuncias.aspx?ID=" + ID);
        }
    }
}