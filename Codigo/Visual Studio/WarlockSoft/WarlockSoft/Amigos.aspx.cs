using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class Amigos : System.Web.UI.Page
    {
        new String ID = "";
        String[] Contactos = new String[100];
        String NickN = "";
        int ContC = 0;
        int h = 50;

        WS_AgregarContacto.AgregarContacto ACo = new WS_AgregarContacto.AgregarContacto();
        String Nom1 = "", Nom2 = "";
        Boolean Am1 = false, Am2 = false;
        String ID2 = "";

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            
            NickN = ACo.ObtenerNombreUsuario(ID);

            Contactos = ACo.ObtenerListaContactos(ID, NickN);

            while (Contactos[ContC] != null)
            {
                TableRow Fila = new TableRow();
                tblAmigos.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = Contactos[ContC];
                Fila.Cells.Add(Celda1);
                tblAmigos.Height = h;
                h = h + 50;

                cmbAmigos.Items.Add(Contactos[ContC]);

                ContC++;
            }
        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            WS_EliminarContacto.EliminarContacto EC = new WS_EliminarContacto.EliminarContacto();

            ID2 = EC.ObtenerIDUsuario(cmbAmigos.SelectedValue);

            Nom1 = ACo.ObtenerNombreUsuario(ID);
            Nom2 = cmbAmigos.SelectedValue;

            Am1 = ACo.ComprobarAmistad(ID, Nom2);
            Am2 = ACo.ComprobarAmistad(ID2, Nom1);
            
            if (Am1 == true)
            {
                EC.EliminarAmigo(ID, Nom2);
                Response.Redirect("Amigos.aspx?ID=" + ID);
            }
            else if (Am2 == true)
            {
                EC.EliminarAmigo(ID2, Nom1);
                Response.Redirect("Amigos.aspx?ID=" + ID);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Error al eliminar!')");
                Response.Write("</script>");
            }
        }
    }
}