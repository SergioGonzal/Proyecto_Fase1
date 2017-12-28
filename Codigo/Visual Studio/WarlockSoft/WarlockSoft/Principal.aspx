<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Principal.aspx.cs" Inherits="WarlockSoft.Principal" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Principal</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 800px;
            height: 530px;
            overflow: scroll;
            position: absolute;
            left: 350px;
            top: 150px;
        }
        .auto-style2 {
            z-index: 100;
            left: 600px;
            position: absolute;
            top: 30px;
        }
    </style>
        
</head>
<body background="Recursos\Fondo.png">
    <form id="form1" runat="server">
        
        <asp:TextBox ID="txtBuscar" runat="server" Font-Names="Rockwell" Font-Size="X-Large" CssClass="auto-style2"></asp:TextBox>
        <asp:ImageButton ID="btnBuscar" Style="Z-INDEX: 100; LEFT: 875px; POSITION: absolute; TOP: 30px" runat="server" Height="35px" ImageUrl="Recursos/Buscar.png" Width="35px" OnClick="ImageButton1_Click" />
        <asp:HyperLink ID="hlkCerrar" Style="Z-INDEX: 100; LEFT: 1350px; POSITION: absolute; TOP: 40px" runat="server" Font-Names="Rockwell" NavigateUrl="IniciarSesion.aspx">Cerrar Sesión</asp:HyperLink>
        
        <div class="auto-style1">
        


        </div>

        <asp:ImageButton ID="btnMiPerfil" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 150px" runat="server" Height="30px" ImageUrl="Recursos/btnPerfil.png" Width="180px" OnClick="btnMiPerfil_Click" />
        <asp:ImageButton ID="btnAmigos" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 200px" runat="server" Height="30px" ImageUrl="Recursos/btnAmigos.png" Width="180px" OnClick="btnAmigos_Click" />
        <asp:ImageButton ID="btnMensajes" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 250px" runat="server" Height="30px" ImageUrl="Recursos/btnMensajes.png" Width="180px" OnClick="btnMensajes_Click" />
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" Font-Size="X-Large" Text="Explorar"></asp:Label>
        <asp:ImageButton ID="btnAsociacion" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 350px" runat="server" Height="30px" ImageUrl="Recursos/btnAsociacion.png" Width="180px" OnClick="btnAsociacion_Click" />
        <asp:ImageButton ID="btnProyectos" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 400px" runat="server" Height="30px" ImageUrl="Recursos/btnProyecto.png" Width="180px" OnClick="btnProyectos_Click" />
        <asp:ImageButton ID="btnTareas" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 450px" runat="server" Height="30px" ImageUrl="Recursos/btnTarea.png" Width="180px" OnClick="btnTareas_Click" />
        <asp:Label ID="Label2" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 500px" runat="server" Font-Names="Rockwell" Font-Size="X-Large" Text="Nuevo"></asp:Label>
        <asp:ImageButton ID="btnAsociacionN" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 550px" runat="server" Height="30px" ImageUrl="Recursos/btnAsociacionN.png" Width="180px" OnClick="btnAsociacionN_Click" />
        <asp:ImageButton ID="btnProyectoN" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 600px" runat="server" Height="30px" ImageUrl="Recursos/btnProyectoN.png" Width="180px" OnClick="btnProyectoN_Click" />
        <asp:ImageButton ID="btnTareaN" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 650px" runat="server" Height="30px" ImageUrl="Recursos/btnTareaN.png" Width="180px" OnClick="btnTareaN_Click" />
        
        
    </form>
</body>
</html>
