using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class Denunciar : System.Web.UI.Page
    {
        new String ID = "";
        String Elemento = "";
        String IDE = "";
        String NombreElemento = "";

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            Elemento = Convert.ToString(Request.QueryString["Elemento"]);
            IDE = Convert.ToString(Request.QueryString["IDE"]);

        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnDenunciar_Click(object sender, EventArgs e)
        {
            WS_Denunciar.Denunciar D = new WS_Denunciar.Denunciar();

            if (Elemento == "Proyecto")
            {
                NombreElemento = D.ObtenerProyectoD(IDE);
            }
            else if (Elemento == "Asociacion")
            {
                NombreElemento = D.ObtenerAsociacionD(IDE);
            }
            else if (Elemento == "Usuario")
            {
                NombreElemento = D.ObtenerPerfilD(IDE);
            }
            D.DenunciarCC(Elemento, NombreElemento, txtMotivo.Text, ID);
            Response.Redirect("Principal.aspx?ID=" + ID);
        }
    }
}