<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="DisconnectedDemo.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h2>Employee Form (Disconnected Architecture)</h2>
            <asp:Label ID="Label1" runat="server" Text="Emp No:"></asp:Label>
&nbsp;
            <asp:TextBox ID="empNo" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label2" runat="server" Text="Name:"></asp:Label>
&nbsp;
            <asp:TextBox ID="empName" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label3" runat="server" Text="Address:"></asp:Label>
&nbsp;
            <asp:TextBox ID="empAddress" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label4" runat="server" Text="Phone:"></asp:Label>
&nbsp;
            <asp:TextBox ID="empCont" runat="server"></asp:TextBox>
            <br />
            <br />
            <br />
            <asp:Button ID="select" runat="server" OnClick="SelectClick" Text="Select" />
&nbsp;
            <asp:Button ID="insert" runat="server" OnClick="InsertClick" Text="Insert" />
&nbsp;
            <asp:Button ID="update" runat="server" OnClick="UpdateClick" Text="Update" />
&nbsp;
            <asp:Button ID="delete" runat="server" OnClick="DeleteClick" Text="Delete" />
&nbsp;
            <asp:Button ID="clear" runat="server" OnClick="ClearClick" Text="Clear" />
            <br />
            <br />
            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
        </div>
    </form>
</body>
</html>
