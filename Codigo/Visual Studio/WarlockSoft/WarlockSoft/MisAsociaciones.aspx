<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MisAsociaciones.aspx.cs" Inherits="WarlockSoft.MisAsociaciones" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Mis Asociaciones</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 400px;
            height: 530px;
            overflow: scroll;
            position: absolute;
            left: 100px;
            top: 150px;
        }
    </style>
</head>
<body background="Recursos\Fondo.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        
        <div class="auto-style1">
            <asp:Table ID="tblAsociaciones" Style="Z-INDEX: 100; LEFT: 5px; POSITION: absolute; TOP: 5px" runat="server" Width="370px" Height="50px" BackColor="White" BorderStyle="Solid" GridLines="Both"></asp:Table>
        </div>

        <asp:DropDownList ID="cmbAsociaciones" Style="Z-INDEX: 100; LEFT: 550px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnVerAs" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" Text="Entrar" OnClick="btnVerAs_Click" />
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 550px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell" Text="Seleccionar Asociacion"></asp:Label>

    </form>
</body>
</html>
