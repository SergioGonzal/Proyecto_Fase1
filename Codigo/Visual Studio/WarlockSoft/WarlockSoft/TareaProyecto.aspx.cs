using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class TareaProyecto : System.Web.UI.Page
    {
        new String ID = "";
        String IDp = "";
        String[] Conocimientos = new String[200];
        int cont = 0;

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);
            IDp = Convert.ToString(Request.QueryString["IDp"]);

            WS_AgregarConocimiento.AgregarConocimiento AC = new WS_AgregarConocimiento.AgregarConocimiento();

            Conocimientos = AC.ObtenerConocimientos();

            while (Conocimientos[cont] != null)
            {
                cmbConocimiento.Items.Add(Conocimientos[cont]);
                cont++;
            }
            
        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (txtNombreT.Text != null & txtDescripcion.Text != null & txtInicio.Text != null)
            {
                WS_AgregarTareaProyecto.CrearTareaProyecto ATP = new WS_AgregarTareaProyecto.CrearTareaProyecto();
                ATP.GuardarTareaProyecto(txtNombreT.Text, txtDescripcion.Text, txtInicio.Text, IDp, cmbConocimiento.SelectedValue);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Campos Vacios!')");
                Response.Write("</script>");
            }

            Response.Redirect("MisProyectos.aspx?ID=" + ID);
        }

        protected void btnGuardarCN_Click(object sender, EventArgs e)
        {
            if (txtNombreT.Text != null & txtDescripcion.Text != null & txtInicio.Text != null)
            {
                WS_AgregarTareaProyecto.CrearTareaProyecto ATP = new WS_AgregarTareaProyecto.CrearTareaProyecto();
                ATP.GuardarTareaProyecto(txtNombreT.Text, txtDescripcion.Text, txtInicio.Text, IDp, cmbConocimiento.SelectedValue);

                Response.Redirect("TareaProyecto.aspx?ID=" + ID + "&IDp=" + IDp);
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Campos Vacios!')");
                Response.Write("</script>");
            }
            
        }
    }
}