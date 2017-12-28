<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="InformacionPerfil.aspx.cs" Inherits="WarlockSoft.InformacionPerfil" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Información</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 450px;
            height: 400px;
            overflow: scroll;
            position: absolute;
            left: 100px;
            top: 200px;
        }
        .auto-style2 {
            width: 450px;
            height: 400px;
            overflow: scroll;
            position: absolute;
            left: 950px;
            top: 200px;
        }
    </style>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">

        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 100px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Font-Size="XX-Large" Text="Habilidades y Conocimientos"></asp:Label>
        <div class="auto-style1">
            <asp:Table ID="tblConocimientos" Style="Z-INDEX: 100; LEFT: 10px; POSITION: absolute; TOP: 10px" runat="server" Width="420px" Height="50px" BackColor="White" BorderStyle="Solid" GridLines="Both"></asp:Table>
        </div>
        <asp:Label ID="lblKarma" Style="Z-INDEX: 100; LEFT: 450px; POSITION: absolute; TOP: 625px" runat="server" Font-Names="Rockwell" Font-Size="X-Large" Text="K-rma: xx"></asp:Label>

        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 200px" runat="server" Text="Conocimientos Nuevos" Font-Names="Rockwell"></asp:Label>
        <asp:Button ID="btnAgregar" Style="Z-INDEX: 100; LEFT: 775px; POSITION: absolute; TOP: 250px" runat="server" Font-Names="Rockwell" Text="Agregar" OnClick="btnAgregar_Click" />
        <asp:DropDownList ID="cmbConocimientosN" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 250px" runat="server" Font-Names="Rockwell">
        </asp:DropDownList>

        <asp:Label ID="Label3" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 350px" runat="server" Text="Conocimientos Adquiridos" Font-Names="Rockwell"></asp:Label>
        <asp:DropDownList ID="cmbConocimientosA" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnEliminar" Style="Z-INDEX: 100; LEFT: 775px; POSITION: absolute; TOP: 400px" runat="server" Text="Eliminar" Font-Names="Rockwell" OnClick="btnEliminar_Click" />
        <asp:Button ID="btnVotar" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" Text="Votar +1" OnClick="btnVotar_Click" />

        <asp:Image ID="Image1" Style="Z-INDEX: 100; LEFT: 900px; POSITION: absolute; TOP: 150px" runat="server" />

        <asp:Label ID="Label4" Style="Z-INDEX: 100; LEFT: 950px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Font-Size="XX-Large" Text="Proyectos y Tareas"></asp:Label>
        <div class="auto-style2">
            <asp:Table ID="Table1" Style="Z-INDEX: 100; LEFT: 10px; POSITION: absolute; TOP: 10px" runat="server" Width="420px" Height="50px" BackColor="White" BorderStyle="Solid" GridLines="Both"></asp:Table>
        </div>
        
    </form>
</body>
</html>
