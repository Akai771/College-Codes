<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WFCon.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="Name:"></asp:Label>
&nbsp;
            <asp:TextBox ID="name" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="Label2" runat="server" Text="Roll No:"></asp:Label>
&nbsp;
            <asp:TextBox ID="roll" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="Label3" runat="server" Text="Address:"></asp:Label>
&nbsp;
            <asp:TextBox ID="address" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="Label4" runat="server" Text="Contact:"></asp:Label>
&nbsp;
            <asp:TextBox ID="contact" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Button ID="select" runat="server" Text="Select" OnClick="Select_Click" />
&nbsp;
            <asp:Button ID="insert" runat="server" Text="Insert" OnClick="Insert_Click" />
&nbsp;
            <asp:Button ID="update" runat="server" Text="Update" OnClick="Update_Click" />
&nbsp;
            <asp:Button ID="delete" runat="server" Text="Delete" OnClick="Delete_Click" />
&nbsp;
            <asp:Button ID="clear" runat="server" Text="Clear" OnClick="Clear_Click" />
&nbsp;
            <asp:Button ID="show" runat="server" Text="Show All" OnClick="Show_Click" />
            <br />
            <br />
            <br />
            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
            <br />
            <asp:Label ID="lname" runat="server" Text="Label"></asp:Label>
            <br />
            <asp:Label ID="lroll" runat="server" Text="Label"></asp:Label>
            <br />
            <asp:Label ID="laddress" runat="server" Text="Label"></asp:Label>
            <br />
            <asp:Label ID="lcontact" runat="server" Text="Label"></asp:Label>
        </div>
    </form>
</body>
</html>
