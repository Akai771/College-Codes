<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="ServerStateDemo.Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            Welcome,
            <asp:Label ID="lblUser" runat="server"></asp:Label>
            <br />
            <br />
            Total User:&nbsp;
            <asp:Label ID="lblUsers" runat="server"></asp:Label>
            <br />
            <br />
            Total Hits:&nbsp;
            <asp:Label ID="lblHits" runat="server"></asp:Label>
            <br />
            <br />
            <asp:Button ID="btnLogout" runat="server" Text="Logout" OnClick="BtnLogout_Click" />
        </div>
    </form>
</body>
</html>
