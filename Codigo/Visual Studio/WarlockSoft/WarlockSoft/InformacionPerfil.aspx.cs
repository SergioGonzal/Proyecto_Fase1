using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class InformacionPerfil : System.Web.UI.Page
    {
        new String ID = "";
        String IDv = "";

        String [] Conocimientos = new String[200];
        String [] IDConocimientosU = new String[200];
        String[] ConocimientosU = new String[200];
        String[] Karma = new String[200];
        int cont = 0;
        int contC = 0;
        int h = 50;
        int KarmaTotal = 0;
        
        WS_AgregarConocimiento.AgregarConocimiento AC = new WS_AgregarConocimiento.AgregarConocimiento();
        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDv = Convert.ToString(Request.QueryString["IDv"]);

            if (IDv == null | IDv == "")
            {
                btnVotar.Enabled = false;

                IDConocimientosU = AC.ObtenerIDConocimientosUsuario(ID);
                Karma = AC.ObtenerKarmaConocimientosUsuario(ID);
            }
            else
            {
                btnEliminar.Enabled = false;

                IDConocimientosU = AC.ObtenerIDConocimientosUsuario(IDv);
                Karma = AC.ObtenerKarmaConocimientosUsuario(IDv);
                
            }
            ConocimientosU = AC.ObtenerConocimientosUsuario(IDConocimientosU);
            //--------------------------------------
            Conocimientos = AC.ObtenerConocimientos();
            while (Conocimientos[cont]!= null)
            {
                cont++;
            }
            for (int i =0; i<cont; i++)
            {
                cmbConocimientosN.Items.Add(Conocimientos[i]);
            }
            //---------------------------------------
            while (ConocimientosU[contC] != null)
            {
                contC++;
            }

            for (int i = 0; i < contC; i++)
            {
                TableRow Fila = new TableRow();
                tblConocimientos.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = ConocimientosU[i];
                Fila.Cells.Add(Celda1);

                TableCell Celda2 = new TableCell();
                Celda2.Text = Karma[i];
                Fila.Cells.Add(Celda2);

                tblConocimientos.Height = h;
                h = h + 50;

                KarmaTotal = KarmaTotal + Int16.Parse(Karma[i]);

                cmbConocimientosA.Items.Add(ConocimientosU[i]);
            }

            lblKarma.Text = "K-rma: "+ KarmaTotal;

            //Codigo pa agregar proyectos
        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnAgregar_Click(object sender, EventArgs e)
        {
            string IDC = "";
            string IDH = "";
            IDC = AC.ObtenerIDConocimiento(cmbConocimientosN.SelectedValue);
            IDH = AC.ObtenerIDHabilidad(cmbConocimientosN.SelectedValue);

            if (IDv == null | IDv == "")
            {
                if (AC.VerificarConocimiento(IDC, ID) == false)
                {
                    AC.GuardarConocimiento(IDC, ID);
                    if (AC.VerificarHabilidad(IDH, ID) == false)
                    {
                        AC.GuardarHabilidad(ID, IDH);
                    }
                    else
                    {
                        Response.Write("<script language=javascript>");
                        Response.Write("alert('Habilidad ya Adquirida!')");
                        Response.Write("</script>");
                    }
                }
                else
                {
                    Response.Write("<script language=javascript>");
                    Response.Write("alert('Conocimiento ya Adquirido!')");
                    Response.Write("</script>");
                }
            }
            else
            {
                if (AC.VerificarConocimiento(IDC, IDv) == false)
                {
                    AC.GuardarConocimiento(IDC, IDv);
                    if (AC.VerificarHabilidad(IDH, IDv) == false)
                    {
                        AC.GuardarHabilidad(IDv, IDH);
                    }
                    else
                    {
                        Response.Write("<script language=javascript>");
                        Response.Write("alert('Habilidad ya Adquirida!')");
                        Response.Write("</script>");
                    }
                }
                else
                {
                    Response.Write("<script language=javascript>");
                    Response.Write("alert('Conocimiento ya Adquirido!')");
                    Response.Write("</script>");
                }

            }
            Response.Redirect("InformacionPerfil.aspx?ID=" + ID + "&IDv=" + IDv);
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            WS_EliminarConocimiento.EliminarConocimiento EC = new WS_EliminarConocimiento.EliminarConocimiento();
            string IDCE = "";
            IDCE = AC.ObtenerIDConocimiento(cmbConocimientosA.SelectedValue);
            EC.EliminarConocimientoUsuario(IDCE,ID);

            Response.Redirect("InformacionPerfil.aspx?ID=" + ID + "&IDv=" + IDv);
        }

        protected void btnVotar_Click(object sender, EventArgs e)
        {
            WS_VotarConocimiento.VotarConocimiento VC = new WS_VotarConocimiento.VotarConocimiento();
            int Karma = 0;
            string IDCV = "";
            IDCV = AC.ObtenerIDConocimiento(cmbConocimientosA.SelectedValue);

            Karma = Convert.ToInt32(VC.ObtenerKarmaConocimiento(IDCV,IDv));
            Karma = Karma + 1;

            String Krma = Convert.ToString(Karma);

            VC.Votar(IDCV, IDv, Krma);

            Response.Redirect("InformacionPerfil.aspx?ID=" + ID + "&IDv=" + IDv);
           
        }
    }
}