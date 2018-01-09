using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class Miembros : System.Web.UI.Page
    {
        new String ID = "";
        String IDA = "";
        String[] Datos = new String[200];
        String[] Contactos = new String[100];
        int contD = 0;
        int ContC = 0;
        String NickN = "";
        int h = 50;

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDA = Convert.ToString(Request.QueryString["IDA"]);

            WS_InvitarAsociacion.InvitarAsociacion IA = new WS_InvitarAsociacion.InvitarAsociacion();
            Datos = IA.ObtenerMiembrosAsociacion(IDA);

            while (Datos[contD] != null)
            {
                TableRow Fila = new TableRow();
                tblMiembros.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = Datos[contD];
                Fila.Cells.Add(Celda1);

                TableCell Celda2 = new TableCell();
                Celda2.Text = Datos[contD+1];
                Fila.Cells.Add(Celda2);

                tblMiembros.Height = h;
                h = h + 50;

                cmbMiembros.Items.Add(Datos[contD]);

                contD++;
                contD++;
            }
            //------------------------------------------------

            WS_AgregarContacto.AgregarContacto ACo = new WS_AgregarContacto.AgregarContacto();

            NickN = ACo.ObtenerNombreUsuario(ID);
            Contactos = ACo.ObtenerListaContactos(ID, NickN);

            while (Contactos[ContC] != null)
            {
                cmbContactos.Items.Add(Contactos[ContC]);

                ContC++;
            }

        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnInvitar_Click(object sender, EventArgs e)
        {
            WS_InvitarAsociacion.InvitarAsociacion IA = new WS_InvitarAsociacion.InvitarAsociacion();
            
            if (IA.VerificarMiembro(cmbContactos.SelectedValue, IDA) == false)
            {
                IA.EnviarInvitacion(IDA, cmbContactos.SelectedValue);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('El usuario ya se encuentra en la asociacion!')");
                Response.Write("</script>");
            }
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            WS_EliminarMiembro.EliminarMiembro EM = new WS_EliminarMiembro.EliminarMiembro();

            EM.EliminarMiembroA(cmbMiembros.SelectedValue, IDA);

            Response.Redirect("Miembros.aspx?ID=" + ID + "&IDA=" + IDA);
        }

        protected void btnSalir_Click(object sender, EventArgs e)
        {
            WS_EliminarMiembro.EliminarMiembro EM = new WS_EliminarMiembro.EliminarMiembro();

            EM.SalirAsociacion(ID, IDA);

            Response.Redirect("Principal.aspx?ID=" + ID);
        }
    }
}