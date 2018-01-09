<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CargaMasiva.aspx.cs" Inherits="WarlockSoft.CargaMasiva" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Carga Masiva</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
       
        <asp:RadioButtonList ID="rbtnCargas" Style="Z-INDEX: 100; LEFT: 50px; POSITION: absolute; TOP: 200px" runat="server" Font-Names="Rockwell">
            <asp:ListItem>Usuarios y  Asociaciones</asp:ListItem>
            <asp:ListItem>Estados y Comentarios</asp:ListItem>
            <asp:ListItem>Proyectos</asp:ListItem>
            <asp:ListItem>Tareas Individuales</asp:ListItem>
        </asp:RadioButtonList>
        <asp:Button ID="btnCargar" Style="Z-INDEX: 100; LEFT: 100px; POSITION: absolute; TOP: 450px" runat="server" Font-Names="Rockwell" Text="Cargar a BD" OnClick="btnCargar_Click" />
        <asp:TextBox ID="txtCarga" Style="Z-INDEX: 100; LEFT: 300px; POSITION: absolute; TOP: 150px" runat="server" Font-Names="Rockwell" Height="500px" TextMode="MultiLine" Width="1000px"></asp:TextBox>
       
    </form>
</body>
</html>
