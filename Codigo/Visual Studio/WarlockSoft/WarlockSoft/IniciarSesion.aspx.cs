using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using WarlockSoft.WS_IniciarSesion;
using WarlockSoft.WS_CrearCuenta;

namespace WarlockSoft
{
    public partial class IniciarSesion : System.Web.UI.Page
    {

        new String ID = "";

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnIniciar_Click(object sender, EventArgs e)
        {
            WS_IniciarSesion.IniciarSesion IS = new WS_IniciarSesion.IniciarSesion();

            if (IS.BuscarCorreo(txtCorreo.Text) == true)
            {
                if (IS.CompararContrasena(txtCorreo.Text, txtContraseña.Text) == true)
                {
                    ID = IS.ObtenerID(txtCorreo.Text);
                    Response.Write("<script language=javascript>");
                    Response.Write("alert('"+ID+"')");
                    Response.Write("</script>");

                    Response.Redirect("Principal.aspx?ID=" + ID );
                }
                else
                {
                    Response.Write("<script language=javascript>");
                    Response.Write("alert('Contraseña incorrecta!')");
                    Response.Write("</script>");
                }
            }
            else
            {
                Response.Write("<script language=javascript>");
                Response.Write("alert('El correo no tiene una cuenta vinculada!')");
                Response.Write("</script>");
            }

        }

        protected void btnCrear_Click(object sender, EventArgs e)
        {
            if (txtNombreC.Text != "" & txtNick.Text != "" & txtCorreoN.Text != "" & txtContraseñaN.Text != "" & txtFecha.Text != "")
            {
                WS_CrearCuenta.CrearCuenta CC = new WS_CrearCuenta.CrearCuenta();

                if (CC.BuscarNick(txtNick.Text) == false)
                {
                    if (CC.BuscarCorreo(txtCorreoN.Text) == false)
                    {
                        CC.AgregarCuenta(txtNombreC.Text, txtNick.Text, txtCorreoN.Text, txtContraseñaN.Text, txtFecha.Text);

                        Response.Write("<script language=javascript>");
                        Response.Write("alert('Cuenta Creada!')");
                        Response.Write("</script>");

                        txtNombreC.Text = "";
                        txtNick.Text = "";
                        txtCorreoN.Text = "";
                    }
                    else
                    {
                        Response.Write("<script language=javascript>");
                        Response.Write("alert('El correo ya tiene una cuenta vinculada!')");
                        Response.Write("</script>");
                    }
                }
                else
                {
                    Response.Write("<script language=javascript>");
                    Response.Write("alert('NickName en uso! Elija otro!')");
                    Response.Write("</script>");
                }
                
            }
            else {
                Response.Write("<script language=javascript>");
                Response.Write("alert('Error! Campo(s) Vacio(s)!')");
                Response.Write("</script>");
            }
        }
    }
}