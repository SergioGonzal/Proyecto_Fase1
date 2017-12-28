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
        int contTareasP = 0;
        int h = 50;
        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDp = Convert.ToString(Request.QueryString["IDp"]);

            WS_AgregarTareaProyecto.CrearTareaProyecto ATP = new WS_AgregarTareaProyecto.CrearTareaProyecto();
            TareasP = ATP.ObtenerTareasProyecto(IDp);

            while (TareasP[contTareasP] != null)
            {
                TableRow Fila = new TableRow();
                tblTareasProyecto.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = TareasP[contTareasP];
                Fila.Cells.Add(Celda1);

                tblTareasProyecto.Height = h;
                h = h + 50;
                
                cmbTareasProyecto.Items.Add(TareasP[contTareasP]);

                contTareasP++;
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
    }
}