<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="NuevaAsociacion.aspx.cs" Inherits="WarlockSoft.NuevaAsociacion" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Crear Asociacion</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style type="text/css">
        .auto-style1 {
            z-index: 100;
            left: 700px;
            position: absolute;
            top: 350px;
            height: 120px;
        }
    </style>
</head>
<body background="Recursos\Fondo.png">
    <form id="form1" runat="server">
        
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" Text="Nombre Asociación:"></asp:Label>
        <asp:TextBox ID="txtNombreAs" Style="Z-INDEX: 100; LEFT: 700px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell"></asp:TextBox>
        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 350px"  runat="server" Font-Names="Rockwell" Text="Objetivo:"></asp:Label>
        <asp:TextBox ID="txtObjetivo" runat="server" Font-Names="Rockwell" CssClass="auto-style1" TextMode="MultiLine"></asp:TextBox>
        
        <asp:Button ID="btnCrear" Style="Z-INDEX: 100; LEFT: 700px; POSITION: absolute; TOP: 500px" runat="server" Font-Names="Rockwell" Text="Crear Asociación" OnClick="btnCrear_Click" />
        
    </form>
</body>
</html>
