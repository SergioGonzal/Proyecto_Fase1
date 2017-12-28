<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TareaProyecto.aspx.cs" Inherits="WarlockSoft.TareaProyecto" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Tareas de Proyecto</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
        


        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 250px" runat="server" Font-Names="Rockwell" Text="Nombre de Tarea:"></asp:Label>
        <asp:TextBox ID="txtNombreT" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 250px" runat="server" Font-Names="Rockwell"></asp:TextBox>
        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" Text="Fecha de Inicio:"></asp:Label>
        <asp:TextBox ID="txtInicio" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" TextMode="Date"></asp:TextBox>
       <asp:Label ID="Label4" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell" Text="Conocimiento:"></asp:Label>
        <asp:DropDownList ID="cmbConocimiento" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Label ID="Label3" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" Text="Descripción:"></asp:Label>
        <asp:TextBox ID="txtDescripcion" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" TextMode="MultiLine" Height="100px"></asp:TextBox>
        <asp:Button ID="btnGuardarCN" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 600px"  runat="server" Font-Names="Rockwell" Text="Guardar y Crear Nueva Tarea" OnClick="btnGuardarCN_Click" />
        <asp:Button ID="btnGuardar" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 550px" runat="server" Font-Names="Rockwell" Text="Guardar y Salir" OnClick="btnGuardar_Click" />
        


        
        


    </form>
</body>
</html>
