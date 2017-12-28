<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DetallesProyecto.aspx.cs" Inherits="WarlockSoft.DetallesProyecto" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Informacion de Proyecto</title>
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
       
        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Font-Size="XX-Large" Text="Tareas del Proyecto"></asp:Label>
        <div class="auto-style1">
        
            <asp:Table ID="tblTareasProyecto" runat="server" BorderStyle="Solid" BorderWidth="1px" Font-Names="Rockwell" Font-Underline="False" GridLines="Both" Height="50px" Width="370px"></asp:Table>

        </div>
        <asp:Button ID="btnAgregarTarea" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell" OnClick="btnAgregarTarea_Click" Text="Agregar Tareas" />
        
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell" Text="Detalle de Tarea"></asp:Label>
        <asp:DropDownList ID="cmbTareasProyecto" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 400px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnVerInfoTarea" Style="Z-INDEX: 100; LEFT: 750px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" Text="Ver Información de Tarea" />

        

    </form>
</body>
</html>
