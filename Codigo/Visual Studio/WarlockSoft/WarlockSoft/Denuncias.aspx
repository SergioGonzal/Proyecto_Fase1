<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Denuncias.aspx.cs" Inherits="WarlockSoft.Denuncias" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Denuncias</title>
    <link rel="shortcut icon" href="Recursos\WS.ico"/>
    <style> 
        .auto-style1 {
            width: 800px;
            height: 400px;
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
       
        <div class="auto-style1">
        
            <asp:Table ID="tblDenuncias" runat="server" BorderStyle="Solid" BorderWidth="1px" Font-Names="Rockwell" Font-Underline="False" GridLines="Both" Height="50px" Width="770px"></asp:Table>

        </div>

    </form>
</body>
</html>
