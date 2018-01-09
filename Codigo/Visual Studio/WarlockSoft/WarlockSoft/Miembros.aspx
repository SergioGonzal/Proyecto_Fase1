<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Miembros.aspx.cs" Inherits="WarlockSoft.Miembros" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Miembros</title>
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
            <asp:Table ID="tblMiembros" Style="Z-INDEX: 100; LEFT: 5px; POSITION: absolute; TOP: 5px" runat="server" Width="370px" Height="50px" BackColor="White" BorderStyle="Solid" GridLines="Both"></asp:Table>
        </div>
        <asp:Button ID="btnInvitar" Style="Z-INDEX: 100; LEFT: 800px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" OnClick="btnInvitar_Click" Text="Invitar Miembros" />
        <asp:DropDownList ID="cmbMiembros" Style="Z-INDEX: 100; LEFT: 550px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnEliminar" Style="Z-INDEX: 100; LEFT: 550px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" OnClick="btnEliminar_Click" Text="Eliminar Miembro" />
        <asp:DropDownList ID="cmbContactos" Style="Z-INDEX: 100; LEFT: 800px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnSalir" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" Text="Salir de Asociación" OnClick="btnSalir_Click" />
    </form>
</body>
</html>
