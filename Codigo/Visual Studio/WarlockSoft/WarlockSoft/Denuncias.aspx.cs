using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WarlockSoft
{
    public partial class Denuncias : System.Web.UI.Page
    {
        new String ID = "";
        String[] InfoDenuncias = new String[200];
        int contD = 0;
        int h = 50;

        protected void Page_Load(object sender, EventArgs e)
        {
            ID = Convert.ToString(Request.QueryString["ID"]);

            WS_Denunciar.Denunciar D = new WS_Denunciar.Denunciar();
            InfoDenuncias = D.ObtenerDenuncias();

            TableRow Fila0 = new TableRow();
            tblDenuncias.Rows.Add(Fila0);
            Fila0.BackColor = System.Drawing.Color.Magenta;

            TableCell Celda01 = new TableCell();
            Celda01.Text = "Elemento";
            Fila0.Cells.Add(Celda01);

            TableCell Celda02 = new TableCell();
            Celda02.Text = "Nombre";
            Fila0.Cells.Add(Celda02);

            TableCell Celda03 = new TableCell();
            Celda03.Text = "Motivo";
            Fila0.Cells.Add(Celda03);

            TableCell Celda04 = new TableCell();
            Celda04.Text = "Denunciante";
            Fila0.Cells.Add(Celda04);

            tblDenuncias.Height = h;
            h = h + 50;

            while (InfoDenuncias[contD] != null)
            {
                TableRow Fila = new TableRow();
                tblDenuncias.Rows.Add(Fila);
                Fila.BackColor = System.Drawing.Color.SkyBlue;

                TableCell Celda1 = new TableCell();
                Celda1.Text = InfoDenuncias[contD]; contD++;
                Fila.Cells.Add(Celda1);

                TableCell Celda2 = new TableCell();
                Celda2.Text = InfoDenuncias[contD]; contD++;
                Fila.Cells.Add(Celda2);

                TableCell Celda3 = new TableCell();
                Celda3.Text = InfoDenuncias[contD]; contD++;
                Fila.Cells.Add(Celda3);

                TableCell Celda4 = new TableCell();
                Celda4.Text = InfoDenuncias[contD]; contD++;
                Fila.Cells.Add(Celda4);

                tblDenuncias.Height = h;
                h = h + 50;
                
            }

        }

        protected void btnIcono_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Principal.aspx?ID=" + ID);
        }
    }
}