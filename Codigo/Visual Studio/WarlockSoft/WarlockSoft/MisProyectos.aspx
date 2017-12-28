<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MisProyectos.aspx.cs" Inherits="WarlockSoft.MisProyectos" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Mis Proyectos</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 400px;
            height: 500px;
            overflow: scroll;
            position: absolute;
            left: 50px;
            top: 200px;
        }
    </style>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 150px" runat="server" Text="Mis Proyectos" Font-Names="Rockwell" Font-Size="XX-Large"></asp:Label>
        <div class="auto-style1">
        
            <asp:Table ID="tblMisProyectos" runat="server" BorderStyle="Solid" BorderWidth="1px" Font-Names="Rockwell" Font-Underline="False" GridLines="Both" Height="50px" Width="370px"></asp:Table>

        </div>

        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" Text="Detalles"></asp:Label>
        <asp:DropDownList ID="cmbMisProyectos" Style="Z-INDEX: 500; LEFT: 500px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell">
        </asp:DropDownList>
        <asp:Button ID="btnVerInfo" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" OnClick="Button1_Click" Text="Ver Detalles" />

    </form>
</body>
</html>
