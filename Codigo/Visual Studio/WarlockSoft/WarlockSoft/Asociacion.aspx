<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Asociacion.aspx.cs" Inherits="WarlockSoft.Asociacion" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Asociación</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 800px;
            height: 400px;
            overflow: scroll;
            position: absolute;
            left: 350px;
            top: 300px;
        }
        .auto-style2 {
            z-index: 100;
            left: 350px;
            position: absolute;
            top: 150px;
            height: 120px;
            width: 650px;
        }
    </style>
</head>
<body background="Recursos\Fondo.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        
        <asp:Button ID="btnMiembros" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 200px" runat="server" OnClick="btnMiembros_Click" Text="Ver Miembros" Font-Names="Rockwell" />
        <asp:Button ID="btnDenunciar" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 250px" runat="server" Font-Names="Rockwell" OnClick="btnDenunciar_Click" Text="Denunciar" />
        
        <asp:TextBox ID="txtPublicacion" runat="server" Font-Names="Rockwell" TextMode="MultiLine" CssClass="auto-style2"></asp:TextBox>
        <asp:Button ID="btnPublicar" Style="Z-INDEX: 100; LEFT: 1050px; POSITION: absolute; TOP: 200px" runat="server" Text="Publicar" Font-Names="Rockwell" OnClick="btnPublicar_Click" />
        <div class="auto-style1">
            <asp:Table ID="tblPublicaciones" Style="Z-INDEX: 100; LEFT: 10px; POSITION: absolute; TOP: 10px" runat="server" Width="750px" Height="50px" BackColor="White" BorderStyle="Solid" GridLines="Both"></asp:Table>
        </div>
        
    </form>
</body>
</html>
