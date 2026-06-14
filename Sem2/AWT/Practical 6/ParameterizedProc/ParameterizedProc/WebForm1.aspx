<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ParameterizedProc.WebForm1" %>

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
            <asp:TextBox ID="id" runat="server"></asp:TextBox>
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
            <asp:Label ID="Label4" runat="server" Text="Country"></asp:Label>
&nbsp;
            <asp:TextBox ID="country" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Button ID="Button1" runat="server" Text="Show Data" OnClick="ShowClick" />
&nbsp;
            <asp:Button ID="insert" runat="server" Text="Insert" OnClick="InsertClick" />
&nbsp;
            <asp:Button ID="update" runat="server" Text="Update" OnClick="UpdateClick" />
&nbsp;
            <asp:Button ID="delete" runat="server" Text="Delete" OnClick="DeleteClick" />
&nbsp;
            <asp:Button ID="clear" runat="server" Text="Clear" OnClick="ClearClick" />
            <br />
            <br />
            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
        </div>
    </form>
</body>
</html>
