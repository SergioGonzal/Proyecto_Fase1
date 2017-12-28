<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Amigos.aspx.cs" Inherits="WarlockSoft.Amigos" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Amigos</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 350px;
            height: 400px;
            overflow: scroll;
            position: absolute;
            left: 100px;
            top: 200px;
        }
    </style>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 100px; POSITION: absolute; TOP: 130px" runat="server" Text="Amigos" Font-Names="Rockwell" Font-Size="XX-Large"></asp:Label>
        <div class="auto-style1">
            <asp:Table ID="tblAmigos" Style="Z-INDEX: 100; LEFT: 10px; POSITION: absolute; TOP: 10px" runat="server" Width="320px" Height="500px" BackColor="White" BorderStyle="Solid" GridLines="Both"></asp:Table>
        </div>

        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 325px"  runat="server" Text="Eliminar Contacto" Font-Names="Rockwell"></asp:Label>
        <asp:DropDownList ID="cmbAmigos" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 375px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnEliminar" Style="Z-INDEX: 100; LEFT: 700px; POSITION: absolute; TOP: 375px" runat="server" Text="Eliminar" Font-Names="Rockwell" OnClick="btnEliminar_Click" />
    </form>
</body>
</html>
