using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class MisAsociaciones : System.Web.UI.Page
    {
        new String ID = "";
        String[] asociaciones = new String[50];
        int cont = 0, h =50;

        String IDAsociacion = "";

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);

            WS_CrearAsociacion.CrearAsociacion CA = new WS_CrearAsociacion.CrearAsociacion();
            asociaciones = CA.ObtenerAsociaciones(ID);

            while (asociaciones[cont] != null)
            {
                TableRow Fila = new TableRow();
                tblAsociaciones.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = asociaciones[cont];
                Fila.Cells.Add(Celda1);
                tblAsociaciones.Height = h;
                h = h + 50;

                cmbAsociaciones.Items.Add(asociaciones[cont]);

                cont++;
            }
        }

        protected void btnVerAs_Click(object sender, EventArgs e)
        {
            WS_CrearAsociacion.CrearAsociacion CAn = new WS_CrearAsociacion.CrearAsociacion();

            IDAsociacion = CAn.ObtenerIDAsociacion(cmbAsociaciones.SelectedValue);

            Response.Redirect("Asociacion.aspx?ID=" + ID + "&IDA=" + IDAsociacion);

        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }
    }
}