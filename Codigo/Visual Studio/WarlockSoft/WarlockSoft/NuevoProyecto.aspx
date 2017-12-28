<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="NuevoProyecto.aspx.cs" Inherits="WarlockSoft.NuevoProyecto" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Crear Proyecto</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" Text="Nombre: "></asp:Label>
        <asp:TextBox ID="txtNombre" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell"></asp:TextBox>
        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell" Text="Fecha de Inicio:"></asp:Label>
        <asp:TextBox ID="txtInicio" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell" TextMode="Date"></asp:TextBox>
        <asp:Label ID="Label3" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" Text="Fecha de Fin:"></asp:Label>
        <asp:TextBox ID="txtFin" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" TextMode="Date"></asp:TextBox>
        <asp:Button ID="btnGuardar" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" OnClick="btnGuardar_Click" Text="Crear Proyecto" />
        
    </form>
</body>
</html>
