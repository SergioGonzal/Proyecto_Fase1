using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class Perfil : System.Web.UI.Page
    {
        protected System.Web.UI.WebControls.Table tblPublicaciones;

        new String ID = "";
        String IDv = "";
        String[] Estados = new String[100];
        int cont = 0;
        int h = 50;

        WS_AgregarContacto.AgregarContacto ACo = new WS_AgregarContacto.AgregarContacto();
        String Nom1 = "", Nom2 = "";
        Boolean Am1 = false, Am2 = false;

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDv = Convert.ToString(Request.QueryString["IDv"]);

            Nom1 = ACo.ObtenerNombreUsuario(ID);
            Nom2 = ACo.ObtenerNombreUsuario(IDv);

            if (IDv == null | IDv == "")
            {
                WS_VerPerfil.VerPerfil VP = new WS_VerPerfil.VerPerfil();
                Estados = VP.ObtenerEstados(ID);

                btnAñadirContacto.Enabled = false;
                btnDenunciar.Enabled = false;

                lblUsuario.Text = Nom1;
                
            }
            else
            {
                txtPublicacion.Enabled = false;
                btnPublicar.Enabled = false;

                WS_VerPerfil.VerPerfil VP = new WS_VerPerfil.VerPerfil();
                Estados = VP.ObtenerEstados(IDv);

                //-------------Verificar Amistad------
                
                Am1 = ACo.ComprobarAmistad(ID, Nom2);
                Am2 = ACo.ComprobarAmistad(IDv, Nom1);

                if (Am1 == true | Am2 == true)
                {
                    btnAñadirContacto.Enabled = false;
                }
                //--------------Nombre--------------

                lblUsuario.Text = Nom2;
            }

            while (Estados[cont] != null)
            {
                cont++;
            }

            /* TextBox1 = new TextBox();
             TextBox1.ID = "TextBox1";
             TextBox1.Style["Position"] = "Absolute";
             TextBox1.Style["Top"] = "25px";
             TextBox1.Style["Left"] = "100px";
             Form1.Controls.Add(TextBox1);*/

            for (int i = cont-1; i > -1; i--)
            {
                TableRow Fila = new TableRow();
                tblPublicaciones.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = Estados[i];
                Fila.Cells.Add(Celda1);
                tblPublicaciones.Height = h;
                h = h + 50;
            }
        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnInformacion_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("InformacionPerfil.aspx?ID=" + ID + "&IDv="+ IDv);
        }

        protected void btnDenunciar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Denunciar.aspx?ID=" + ID + "&IDE=" + IDv + "&Elemento=Usuario");
        }

        protected void btnPublicar_Click(object sender, EventArgs e)
        {
            if (txtPublicacion.Text != "")
            {
                WS_PublicarEstado.PublicarEstado PE = new WS_PublicarEstado.PublicarEstado();
                PE.GuardarEstado(txtPublicacion.Text, ID);
                
                Response.Redirect("Perfil.aspx?ID=" + ID);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Campo vacio!')");
                Response.Write("</script>");
            }
        }

        protected void btnAñadirContacto_Click(object sender, ImageClickEventArgs e)
        {
            ACo.GuardarAmigo(ID, Nom2);
            Response.Redirect("Perfil.aspx?ID=" + ID + "&IDv=" + IDv);
        }
    }
}