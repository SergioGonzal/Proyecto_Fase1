<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DetalleTarea.aspx.cs" Inherits="WarlockSoft.DetalleTarea" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Detalle de Tarea</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style type="text/css">
        .auto-style1 {
            z-index: 100;
            left: 50px;
            position: absolute;
            top: 250px;
            height: 131px;
        }
    </style>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
       
        <asp:Label ID="lblNombre" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 200px" runat="server" Font-Names="Rockwell" Text="Nombre: xxxxx"></asp:Label>
        <asp:Label ID="lblDescripcion" runat="server" Font-Names="Rockwell" Text="Descripcion: xxxxxyyyyy" CssClass="auto-style1"></asp:Label>
        <asp:Label ID="lblFechaI" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" Text="Fecha de Inicio: xx/xx/xx"></asp:Label>
        <asp:Label ID="lblEstado" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" Text="Estado: xxxxx"></asp:Label>
        <asp:Label ID="lblUsuario" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 500px" runat="server" Text="Asignado: xxxxx" Font-Names="Rockwell"></asp:Label>
      
        <asp:Button ID="btnTerminar" Style="Z-INDEX: 100; LEFT: 400px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" OnClick="btnTerminar_Click" Text="Dar por Terminada" />
        <asp:Button ID="btnSolicitar" Style="Z-INDEX: 100; LEFT: 400px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" OnClick="btnSolicitar_Click" Text="Solicitar Unirse" />
       
    </form>
</body>
</html>
