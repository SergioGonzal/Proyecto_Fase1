using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class DetallesProyecto : System.Web.UI.Page
    {
        new String ID = "";
        String IDp = "";
        String[] TareasP = new String[100];
        String[] TareasPA = new String[100];
        String[] TareasPB = new String[100];
        String[] TareasPI = new String[100];
        String[] TareasPF = new String[100];

        String[] ConocimientosP = new String[100];
        String[] EstadosP = new String[100];
        int contTareasP = 0;
        int h = 50;
        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDp = Convert.ToString(Request.QueryString["IDp"]);

            WS_AgregarTareaProyecto.CrearTareaProyecto ATP = new WS_AgregarTareaProyecto.CrearTareaProyecto();
            TareasP = ATP.ObtenerTareasProyecto(IDp);
            ConocimientosP = ATP.ObtenerConocimientosTarea(IDp);
            EstadosP = ATP.ObtenerEstadoTareasProyecto(IDp);

            while (TareasP[contTareasP] != null)
            {
                TableRow Fila = new TableRow();
                tblTareasProyecto.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = TareasP[contTareasP];
                Fila.Cells.Add(Celda1);

                TableCell Celda2 = new TableCell();
                Celda2.Text = ConocimientosP[contTareasP];
                Fila.Cells.Add(Celda2);

                TableCell Celda3 = new TableCell();
                Celda3.Text = EstadosP[contTareasP];
                Fila.Cells.Add(Celda3);

                tblTareasProyecto.Height = h;
                h = h + 50;
                
                cmbTareasProyecto.Items.Add(TareasP[contTareasP]);

                contTareasP++;
            }
            //----------------------------------------------------------------------------------------------------

            WS_MostrarTareasEstado.MostrarTareasEstado MTE = new WS_MostrarTareasEstado.MostrarTareasEstado();

            TareasPA = MTE.TareasEstado(IDp, "Activa");
            contTareasP = 0;
            h = 50;

            while (TareasPA[contTareasP] != null)
            {
                TableRow Fila = new TableRow();
                tblActivo.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = TareasPA[contTareasP];
                Fila.Cells.Add(Celda1);

                tblActivo.Height = h;
                h = h + 50;

                cmbTareasActivas.Items.Add(TareasPA[contTareasP]);

                contTareasP++;
            }
            //--------------------------------------------------------------------------------------------------
            TareasPB = MTE.TareasEstado(IDp, "Borrador");
            contTareasP = 0;
            h = 50;

            while (TareasPB[contTareasP] != null)
            {
                TableRow Fila = new TableRow();
                tblBorrador.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = TareasPB[contTareasP];
                Fila.Cells.Add(Celda1);

                tblBorrador.Height = h;
                h = h + 50;

                cmbTareasBorrador.Items.Add(TareasPB[contTareasP]);

                contTareasP++;
            }
            //--------------------------------------------------------------------------------------------------
            TareasPI = MTE.TareasEstado(IDp, "Iniciada");
            contTareasP = 0;
            h = 50;

            while (TareasPI[contTareasP] != null)
            {
                TableRow Fila = new TableRow();
                tblIniciado.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = TareasPI[contTareasP];
                Fila.Cells.Add(Celda1);

                tblIniciado.Height = h;
                h = h + 50;

                cmbTareasIniciadas.Items.Add(TareasPI[contTareasP]);

                contTareasP++;
            }
            //--------------------------------------------------------------------------------------------------
            TareasPF = MTE.TareasEstado(IDp, "Finalizada");
            contTareasP = 0;
            h = 50;

            while (TareasPF[contTareasP] != null)
            {
                TableRow Fila = new TableRow();
                tblFinalizado.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = TareasPF[contTareasP];
                Fila.Cells.Add(Celda1);

                tblFinalizado.Height = h;
                h = h + 50;

                cmbTareasFinalizadas.Items.Add(TareasPF[contTareasP]);

                contTareasP++;
            }

            WS_Extras.Extras E = new WS_Extras.Extras();
            lblCosto.Text = E.ObtenerCosto(IDp);

            Response.Write("<script language=javascript>");
            Response.Write("alert('"+E.ObtenerEstadoProyecto(IDp)+ E.ObtenerCosto(IDp)+"')");
            Response.Write("</script>");

            if (E.ObtenerEstadoProyecto(IDp).Equals("activo"))
            {

            }
            else
            {
                btnPagar.Enabled = false;
            }
        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnAgregarTarea_Click(object sender, EventArgs e)
        {
            Response.Redirect("TareaProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
        }

        protected void btnVerInfoTarea_Click(object sender, EventArgs e)
        {
            String Tarea = "";
            Tarea = cmbTareasProyecto.SelectedValue;
            Response.Redirect("DetalleTarea.aspx?ID=" + ID + "&IDp=" + IDp + "&Tarea=" + Tarea);
        }
        
        protected void btnPassBorrador_Click1(object sender, EventArgs e)
        {
            WS_MostrarTareasEstado.MostrarTareasEstado MTE = new WS_MostrarTareasEstado.MostrarTareasEstado();

            MTE.MoverTarea(cmbTareasActivas.SelectedValue, "Borrador", IDp);
            Response.Redirect("DetallesProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
        }

        protected void btnPassIniciado_Click(object sender, EventArgs e)
        {
            WS_MostrarTareasEstado.MostrarTareasEstado MTE = new WS_MostrarTareasEstado.MostrarTareasEstado();

            MTE.MoverTarea(cmbTareasBorrador.SelectedValue, "Iniciada", IDp);
            Response.Redirect("DetallesProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
        }

        protected void btnPassFinalizado_Click(object sender, EventArgs e)
        {
            WS_MostrarTareasEstado.MostrarTareasEstado MTE = new WS_MostrarTareasEstado.MostrarTareasEstado();

            MTE.MoverTarea(cmbTareasIniciadas.SelectedValue, "Finalizada", IDp);
            Response.Redirect("DetallesProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
        }

        protected void btnDenunciar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Denunciar.aspx?ID=" + ID + "&IDE=" + IDp + "&Elemento=Proyecto");
        }

        protected void btnFinalizarP_Click(object sender, EventArgs e)
        {
            WS_Extras.Extras E = new WS_Extras.Extras();
            E.TerminarProyecto(IDp);

            Response.Redirect("Pago.aspx?ID=" + ID + "&IDp=" + IDp);
        }

        protected void btnPagar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Pago.aspx?ID=" + ID + "&IDp=" + IDp);
        }
    }
}