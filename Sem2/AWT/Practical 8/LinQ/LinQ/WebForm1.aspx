<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="LinQ.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="ID"></asp:Label>
&nbsp;
            <asp:TextBox ID="txtId" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label2" runat="server" Text="Name"></asp:Label>
&nbsp;
            <asp:TextBox ID="name" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label3" runat="server" Text="Age"></asp:Label>
&nbsp;
            <asp:TextBox ID="age" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label4" runat="server" Text="Div"></asp:Label>
&nbsp;
            <asp:TextBox ID="div" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label5" runat="server" Text="Dream Job"></asp:Label>
&nbsp;
            <asp:TextBox ID="dreamJob" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Button ID="insert" runat="server" Text="Insert" OnClick="Insert_Click" />
&nbsp;
            <asp:Button ID="update" runat="server" Text="Update" OnClick="Update_Click" />
&nbsp;
            <asp:Button ID="delete" runat="server" Text="Delete" OnClick="Delete_Click" />
&nbsp;
            <asp:Button ID="select" runat="server" Text="Select" OnClick="Select_Click" />
            <br />
            <br />

            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
        </div>
    </form>
</body>
</html>
