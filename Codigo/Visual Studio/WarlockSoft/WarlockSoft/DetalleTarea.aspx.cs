using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class DetalleTarea : System.Web.UI.Page
    {
        new String ID = "";
        String IDp = "";
        String Tarea = "";
        String[] Datos = new String[4];

        Boolean respuesta = false;

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDp = Convert.ToString(Request.QueryString["IDp"]);
            Tarea = Convert.ToString(Request.QueryString["Tarea"]);

            WS_SolicitarUnionTarea.SolicitarUnionTarea SUT = new WS_SolicitarUnionTarea.SolicitarUnionTarea();
            Datos = SUT.ObtenerDatosTarea(IDp, Tarea);

            lblNombre.Text = "Nombre: "+Datos[0];
            lblDescripcion.Text = "Descripción: "+Datos[1];
            lblFechaI.Text = "Fecha de Inicio: "+Datos[2];
            lblEstado.Text = "Estado: "+Datos[3];

            if (Datos[3].Equals("Finalizada"))
            {
                btnTerminar.Enabled = false;
            }

            WS_Extras.Extras E = new WS_Extras.Extras();
            lblUsuario.Text = "Asignado: " + E.ObtenerEncargado(IDp, Tarea);

        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnSolicitar_Click(object sender, EventArgs e)
        {
            WS_SolicitarUnionTarea.SolicitarUnionTarea SUT = new WS_SolicitarUnionTarea.SolicitarUnionTarea();

            respuesta = SUT.SolicitarTrabajarTarea(Tarea, ID, IDp);

            if (respuesta == true)
            {
                Response.Redirect("DetallesProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('No cuenta con los conocimientos necesarios!')");
                Response.Write("</script>");
            }
        }

        protected void btnTerminar_Click(object sender, EventArgs e)
        {
            WS_SolicitarUnionTarea.SolicitarUnionTarea SUT= new WS_SolicitarUnionTarea.SolicitarUnionTarea();

            SUT.TerminarTarea(Tarea, IDp);
        }
    }
}