<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="EEFDemo.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="PID:"></asp:Label>
&nbsp;
            <asp:TextBox ID="pid" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label2" runat="server" Text="Name:"></asp:Label>
&nbsp;
            <asp:TextBox ID="name" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label3" runat="server" Text="Cost:"></asp:Label>
&nbsp;
            <asp:TextBox ID="cost" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Button ID="insert" runat="server" Text="Insert" OnClick="Insert_Click" />
&nbsp;
            <asp:Button ID="update" runat="server" Text="Update" OnClick="Update_Click" />
&nbsp;
            <asp:Button ID="delete" runat="server" Text="Delete" OnClick="Delete_Click" />
&nbsp;
            <asp:Button ID="show" runat="server" Text="Show Data" OnClick="Show_Click" />
            <br />
            <br />

            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
        </div>
    </form>
</body>
</html>
