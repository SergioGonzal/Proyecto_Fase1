<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PanelAdministrativo.aspx.cs" Inherits="WarlockSoft.PanelAdministrativo" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Panel Administrativo</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
       
        <asp:Button ID="btnDenuncias" Style="Z-INDEX: 100; LEFT: 700px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" OnClick="btnDenuncias_Click" Text="Denuncias" />
        <asp:Button ID="btnCarga" Style="Z-INDEX: 100; LEFT: 700px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell" OnClick="btnCarga_Click" Text="Carga Masiva" />
       
    </form>
</body>
</html>
