<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Perfil.aspx.cs" Inherits="WarlockSoft.Perfil" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Perfil</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 800px;
            height: 400px;
            overflow: scroll;
            position: absolute;
            left: 350px;
            top: 300px;
        }
        .auto-style2 {
            z-index: 100;
            left: 350px;
            position: absolute;
            top: 150px;
            height: 120px;
            width: 650px;
        }
    </style>
</head>
<body background="Recursos\FondoP.png">
    <form id="Form1" runat="server">

        

        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
       
        <asp:Label ID="lblUsuario" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Font-Size="XX-Large" Width="180px" Height="180px" Text="Usuario" BorderWidth="1px"></asp:Label>
        <asp:ImageButton ID="btnInformacion" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 370px" runat="server" Height="30px" ImageUrl="Recursos/btnInformacion.png" Width="180px" OnClick="btnInformacion_Click" />
        <asp:ImageButton ID="btnAñadirContacto"  Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 420px" runat="server" Height="30px" Width="180px" OnClick="btnAñadirContacto_Click" ImageUrl="Recursos/btnAgregarA.png" />
        <asp:Button ID="btnDenunciar" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 470px" runat="server" Font-Names="Rockwell" Text="Denunciar" OnClick="btnDenunciar_Click" />

        <asp:TextBox ID="txtPublicacion" runat="server" Font-Names="Rockwell" TextMode="MultiLine" CssClass="auto-style2"></asp:TextBox>
        <asp:Button ID="btnPublicar" Style="Z-INDEX: 100; LEFT: 1050px; POSITION: absolute; TOP: 200px" runat="server" Text="Publicar" Font-Names="Rockwell" OnClick="btnPublicar_Click" />
        <div class="auto-style1">
            <asp:Table ID="tblPublicaciones" Style="Z-INDEX: 100; LEFT: 10px; POSITION: absolute; TOP: 10px" runat="server" Width="750px" Height="50px" BackColor="White" BorderStyle="Solid" GridLines="Both"></asp:Table>
        </div>


    </form>
</body>
</html>
