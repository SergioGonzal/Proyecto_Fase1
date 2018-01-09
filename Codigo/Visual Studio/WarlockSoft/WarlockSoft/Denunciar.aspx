<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Denunciar.aspx.cs" Inherits="WarlockSoft.Denunciar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Denunciar</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
       
        <asp:TextBox ID="txtMotivo" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 350px" runat="server" Font-Names="Rockwell" Height="200px" TextMode="MultiLine" Width="500px"></asp:TextBox>
        <asp:Button ID="btnDenunciar" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 600px" runat="server" Font-Names="Rockwell" Text="Denunciar" OnClick="btnDenunciar_Click" />
        <asp:Label ID="Label1" Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 300px" runat="server" Font-Names="Rockwell" Text="Motivo: "></asp:Label>
       
    </form>
</body>
</html>
