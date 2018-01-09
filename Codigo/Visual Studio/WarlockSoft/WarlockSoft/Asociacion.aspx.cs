using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class Asociacion : System.Web.UI.Page
    {
        new String ID = "";
        String IDA = "";
        String Rol = "";
       /* String[] Estados = new String[100];
        int cont = 0;
        int h = 50;*/

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDA = Convert.ToString(Request.QueryString["IDA"]);

            WS_InvitarAsociacion.InvitarAsociacion IA = new WS_InvitarAsociacion.InvitarAsociacion();
            Rol = IA.ObtenerRolAsociacion(ID, IDA);



        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnMiembros_Click(object sender, EventArgs e)
        {
            Response.Redirect("Miembros.aspx?ID=" + ID + "&IDA=" + IDA);
        }

        protected void btnPublicar_Click(object sender, EventArgs e)
        {
            
        }

        protected void btnDenunciar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Denunciar.aspx?ID=" + ID + "&IDE=" + IDA + "&Elemento=Asociacion");
        }
    }
}