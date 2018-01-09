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
            height: 300px;
            overflow: scroll;
            position: absolute;
            left: 50px;
            top: 200px;
        }
        .auto-style2{
            width: 150px;
            height: 200px;
            overflow: scroll;
            position: absolute;
            left: 600px;
            top: 200px;
        }
        .auto-style3 {
            width: 150px;
            height: 200px;
            overflow: scroll;
            position: absolute;
            left: 800px;
            top: 200px;
        }
        .auto-style4 {
            width: 150px;
            height: 200px;
            overflow: scroll;
            position: absolute;
            left: 1000px;
            top: 200px;
        }
        .auto-style5 {
            width: 150px;
            height: 200px;
            overflow: scroll;
            position: absolute;
            left: 1200px;
            top: 200px;
        }
        .auto-style6 {
            z-index: 100;
            left: 250px;
            position: absolute;
            top: 650px;
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
        <asp:Button ID="btnAgregarTarea" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 550px" runat="server" Font-Names="Rockwell" OnClick="btnAgregarTarea_Click" Text="Agregar Tareas" />
        
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 250px; POSITION: absolute; TOP: 550px" runat="server" Font-Names="Rockwell" Text="Detalle de Tarea"></asp:Label>
        <asp:DropDownList ID="cmbTareasProyecto" Style="Z-INDEX: 100; LEFT: 250px; POSITION: absolute; TOP: 600px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnVerInfoTarea" runat="server" Font-Names="Rockwell" Text="Ver Información de Tarea" OnClick="btnVerInfoTarea_Click" CssClass="auto-style6" />

        <asp:Label ID="Label3" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Text="Sin Asignar"></asp:Label>
        <div class="auto-style2">
        
            <asp:Table ID="tblActivo" runat="server" BorderStyle="Solid" BorderWidth="1px" Font-Names="Rockwell" Font-Underline="False" GridLines="Both" Height="50px" Width="370px"></asp:Table>

        </div>
        <asp:DropDownList ID="cmbTareasActivas" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 500px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnPassBorrador" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 550px" runat="server" Font-Names="Rockwell" Text="Mover a en Proceso &gt;&gt;" OnClick="btnPassBorrador_Click1" />
        
        <asp:Label ID="Label4" Style="Z-INDEX: 100; LEFT: 800px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Text="En Proceso"></asp:Label>
        <div class="auto-style3">
        
            <asp:Table ID="tblBorrador" runat="server" BorderStyle="Solid" BorderWidth="1px" Font-Names="Rockwell" Font-Underline="False" GridLines="Both" Height="50px" Width="370px"></asp:Table>

        </div>
        <asp:DropDownList ID="cmbTareasBorrador" Style="Z-INDEX: 100; LEFT: 800px; POSITION: absolute; TOP: 500px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnPassIniciado" Style="Z-INDEX: 100; LEFT: 800px; POSITION: absolute; TOP: 550px" runat="server" Font-Names="Rockwell" Text="Mover a Pruebas &gt;&gt;" OnClick="btnPassIniciado_Click" />

        <asp:Label ID="Label5" Style="Z-INDEX: 100; LEFT: 1000px; POSITION: absolute; TOP: 150px"  runat="server" Font-Names="Rockwell" Text="Pruebas"></asp:Label>
        <div class="auto-style4">
        
            <asp:Table ID="tblIniciado" runat="server" BorderStyle="Solid" BorderWidth="1px" Font-Names="Rockwell" Font-Underline="False" GridLines="Both" Height="50px" Width="370px"></asp:Table>

        </div>
        <asp:DropDownList ID="cmbTareasIniciadas" Style="Z-INDEX: 100; LEFT: 1000px; POSITION: absolute; TOP: 500px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        <asp:Button ID="btnPassFinalizado" Style="Z-INDEX: 100; LEFT: 1000px; POSITION: absolute; TOP: 550px" runat="server" Font-Names="Rockwell" Text="Mover a Finalizada &gt;&gt;" OnClick="btnPassFinalizado_Click" />

        <asp:Label ID="Label6" Style="Z-INDEX: 100; LEFT: 1200px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Text="Finalizadas"></asp:Label>
        <div class="auto-style5">
        
            <asp:Table ID="tblFinalizado" runat="server" BorderStyle="Solid" BorderWidth="1px" Font-Names="Rockwell" Font-Underline="False" GridLines="Both" Height="50px" Width="370px"></asp:Table>

        </div>
        <asp:DropDownList ID="cmbTareasFinalizadas" Style="Z-INDEX: 100; LEFT: 1200px; POSITION: absolute; TOP: 500px" runat="server" Font-Names="Rockwell"></asp:DropDownList>
        
        
        <asp:Button ID="btnDenunciar" Style="Z-INDEX: 100; LEFT: 1200px; POSITION: absolute; TOP: 650px" runat="server" Font-Names="Rockwell" Text="Denunciar" OnClick="btnDenunciar_Click" />
        
        
        <asp:Label ID="Label7" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 600px" runat="server" Text="SALARIO:" Font-Size="XX-Large"></asp:Label>
        
        
        <asp:Label ID="lblCosto" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 650px" runat="server" Font-Names="Rockwell" Font-Size="X-Large" Text="XXXX"></asp:Label>
        
        
        <asp:Button ID="btnFinalizarP" Style="Z-INDEX: 100; LEFT: 600px; POSITION: absolute; TOP: 650px" runat="server" Font-Names="Rockwell" Text="Finalizar Proyecto" OnClick="btnFinalizarP_Click" />
        
        <asp:Button ID="btnPagar" Style="Z-INDEX: 100; LEFT: 1000px; POSITION: absolute; TOP: 650px" runat="server" Text="Pagar" Font-Names="Rockwell" OnClick="btnPagar_Click" />
    </form>
</body>
</html>
