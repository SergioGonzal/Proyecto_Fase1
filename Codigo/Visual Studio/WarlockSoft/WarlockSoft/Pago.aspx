<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Pago.aspx.cs" Inherits="WarlockSoft.Pago" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Pago</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>

</head>
<body background="Recursos\FondoP.png">
    <form id="form1" runat="server">
        
        <asp:ImageButton ID="btnIcono" Style="Z-INDEX: 100; LEFT: 0px; POSITION: absolute; TOP: 0px" runat="server" Height="96px" ImageUrl="Recursos/WS.png" Width="96px" OnClick="btnIcono_Click" />
       

        <asp:Label ID="Label1"  Style="Z-INDEX: 100; LEFT: 500px; POSITION: absolute; TOP: 400px" runat="server" Text="Sistema de pago no disponible!"></asp:Label>
       

    </form>
</body>
</html>
