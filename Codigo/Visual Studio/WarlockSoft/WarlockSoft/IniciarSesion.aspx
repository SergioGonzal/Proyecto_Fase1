<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="IniciarSesion.aspx.cs" Inherits="WarlockSoft.IniciarSesion" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>WarlockSoft</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style type="text/css">
        .auto-style1 {
            z-index: 100;
            left: 1150px;
            position: absolute;
            top: 225px;
        }
    </style>
</head>
<body background="Recursos\Fondo.png">
    <form id="form1" runat="server">
        
        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 900px; POSITION: absolute; TOP: 25px" runat="server" Font-Names="Rockwell" Text="Correo:"></asp:Label>
        <asp:TextBox ID="txtCorreo" Style="Z-INDEX: 100; LEFT: 900px; POSITION: absolute; TOP: 45px" runat="server" Font-Names="Rockwell" TextMode="Email"></asp:TextBox>
        <asp:Label ID="Label3" Style="Z-INDEX: 100; LEFT: 1100px; POSITION: absolute; TOP: 25px" runat="server" Font-Names="Rockwell" Text="Contraseña:"></asp:Label>
        <asp:TextBox ID="txtContraseña" Style="Z-INDEX: 100; LEFT: 1100px; POSITION: absolute; TOP: 45px" runat="server" Font-Names="Rockwell" TextMode="Password"></asp:TextBox>
        <asp:Button ID="btnIniciar" Style="Z-INDEX: 100; LEFT: 1300px; POSITION: absolute; TOP: 45px" runat="server" OnClick="btnIniciar_Click" Text="Iniciar Sesión" Font-Names="Rockwell" />
        
         <asp:Image ID="Image1" Style="Z-INDEX: 100; LEFT: 100px; POSITION: absolute; TOP: 200px" runat="server" ImageUrl="Recursos/WS.png" />

        <asp:Label ID="Label4" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 150px" runat="server" Font-Size="XX-Large" Text="REGISTRATE"></asp:Label>
        <asp:Label ID="Label5" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 225px" runat="server" Font-Size="Large" Text="Nombre Completo:"></asp:Label>
        <asp:TextBox ID="txtNombreC" runat="server" Font-Size="Large" CssClass="auto-style1"></asp:TextBox>
        <asp:Label ID="Label9" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 275px" runat="server" Text="NickName:" Font-Size="Large"></asp:Label>
        <asp:TextBox ID="txtNick" Style="Z-INDEX: 100; LEFT: 1150px; POSITION: absolute; TOP: 275px" runat="server" Font-Size="Large"></asp:TextBox>
        <asp:Label ID="Label8" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 325px" runat="server" Text="Correo:" Font-Size="Large"></asp:Label>
        <asp:TextBox ID="txtCorreoN" Style="Z-INDEX: 100; LEFT: 1150px; POSITION: absolute; TOP: 325px" runat="server" Font-Size="Large" TextMode="Email"></asp:TextBox>
        <asp:Label ID="Label6" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 375px" runat="server" Text="Contraseña:" Font-Size="Large"></asp:Label>
        <asp:TextBox ID="txtContraseñaN" Style="Z-INDEX: 100; LEFT: 1150px; POSITION: absolute; TOP: 375px" runat="server" Font-Size="Large" TextMode="Password"></asp:TextBox>
        <asp:Label ID="Label7" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 425px" runat="server" Text="Fecha de Nacimineto:" Font-Size="Large"></asp:Label>
        <asp:TextBox ID="txtFecha" Style="Z-INDEX: 100; LEFT: 1150px; POSITION: absolute; TOP: 425px" runat="server" TextMode="Date" Font-Size="Large"></asp:TextBox>
        
        <asp:Button ID="btnCrear" Style="Z-INDEX: 100; LEFT: 1150px; POSITION: absolute; TOP: 475px" runat="server" Font-Size="Large" Text="Crear Cuenta" OnClick="btnCrear_Click" />
        
    </form>
</body>
</html>
