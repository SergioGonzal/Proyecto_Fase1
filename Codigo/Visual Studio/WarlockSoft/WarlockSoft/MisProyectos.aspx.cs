using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class MisProyectos : System.Web.UI.Page
    {
        new String ID = "";
        String IDp = "";
        String[] proyectos = new string[100];
        String[] Proyectos = new string[100];
        int contP = 0;
        int h = 50;

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);

            WS_CrearProyecto.CrearProyecto CP = new WS_CrearProyecto.CrearProyecto();

            proyectos = CP.ObtenerProyectos(ID);
            while (proyectos[contP] != null)
            {
                TableRow Fila = new TableRow();
                tblMisProyectos.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = proyectos[contP];
                Fila.Cells.Add(Celda1);
                
                tblMisProyectos.Height = h;
                h = h + 50;
                

                cmbMisProyectos.Items.Add(proyectos[contP]);

                contP++;
            }
            contP = 0;

            WS_ObtenerProyectosActivos.MostrarProyectosActivos OPA = new WS_ObtenerProyectosActivos.MostrarProyectosActivos();

            Proyectos = OPA.ObtenerProyectosActivos();

            while (Proyectos[contP] != null)
            {
                cmbProyectos.Items.Add(Proyectos[contP]);
                contP++;
            }


        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            WS_CrearProyecto.CrearProyecto CP = new WS_CrearProyecto.CrearProyecto();
            IDp = CP.ObtenerIDProyecto(cmbMisProyectos.SelectedValue);
            Response.Redirect("DetallesProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
        }

        protected void btnVerOtros_Click(object sender, EventArgs e)
        {
            WS_CrearProyecto.CrearProyecto CP = new WS_CrearProyecto.CrearProyecto();
            IDp = CP.ObtenerIDProyecto(cmbProyectos.SelectedValue);
            Response.Redirect("DetallesProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
        }
    }
}