<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ClientSessionDemo.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            User ID: &nbsp;
            <asp:TextBox ID="userId" runat="server"></asp:TextBox>
        &nbsp;
            <asp:Button ID="saveBtn" runat="server" Text="Save in ViewState" OnClick="SaveBtn_Click" />
        &nbsp;
            <asp:Button ID="getBtn" runat="server" Text="Get ViewState" OnClick="GetBtn_Click" />
        &nbsp;
            <asp:Label ID="viewStateLable" runat="server" ></asp:Label>
            <br />
            <br />
            Hidden Field: &nbsp;
            <asp:HiddenField ID="HiddenField1" runat="server" Value="Value 123" />
            <asp:Button ID="hiddenFieldBtn" runat="server" Text="Get Hidden Field" OnClick="HiddenFieldBtn_Click" />
            <asp:Label ID="hiddenLable" runat="server" ></asp:Label>

            <br />
            <br />
            Query String:
            <asp:TextBox ID="queryStr" runat="server"></asp:TextBox>
            &nbsp;
            <asp:Button ID="queryStrBtn" runat="server" Text="Send via QueryString" OnClick="QueryStrBtn_Click" />
            <br />
            <br />
            Cookies:
            <asp:TextBox ID="cookieTxt" runat="server"></asp:TextBox>
            <asp:Button ID="createBtn" runat="server" Text="Create Cookie" OnClick="CreateBtn_Click" />
            &nbsp;
            <asp:Button ID="readBtn" runat="server" Text="Read Cookie"  OnClick="ReadBtn_Click"/>
            <asp:Label ID="cookieLabel" runat="server" ></asp:Label>
        </div>
    </form>
</body>
</html>
