using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using WarlockSoft.WS_BuscarUsuario;

namespace WarlockSoft
{
    public partial class Principal : System.Web.UI.Page
    {
        new String ID = "";
        String IDbusqueda = "";
        String IDv = "";

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
        }

        protected void btnMiPerfil_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Perfil.aspx?ID=" + ID + "&IDv=" + IDv);
        }

        protected void btnAmigos_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Amigos.aspx?ID=" + ID);
        }

        protected void btnMensajes_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Mensajes.aspx?ID=" + ID);
        }

        protected void btnAsociacion_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MisAsociaciones.aspx?ID=" + ID);
        }

        protected void btnProyectos_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MisProyectos.aspx?ID=" + ID);
        }

        protected void btnTareas_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MisTareas.aspx?ID=" + ID);
        }

        protected void btnProyectoN_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("NuevoProyecto.aspx?ID=" + ID);
        }

        protected void btnTareaN_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("NuevaTarea.aspx?ID=" + ID);
        }

        protected void btnAsociacionN_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("NuevaAsociacion.aspx?ID=" + ID);
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            if (txtBuscar.Text != "")
            {
                WS_BuscarUsuario.BuscarUsuario BU = new WS_BuscarUsuario.BuscarUsuario();

                if (BU.BuscarNickName(txtBuscar.Text) == true)
                {
                    IDbusqueda = BU.ObtenerID2(txtBuscar.Text);

                    Response.Redirect("Perfil.aspx?ID=" + ID +"&IDv=" + IDbusqueda);
                }
                else
                {
                    Response.Write("<script language=javascript>");
                    Response.Write("alert('El NickName no existe!')");
                    Response.Write("</script>");
                }
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Campo vacio!')");
                Response.Write("</script>");
            }
        }
    }
}