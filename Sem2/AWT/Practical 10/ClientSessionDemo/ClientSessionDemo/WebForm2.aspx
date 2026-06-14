<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2.aspx.cs" Inherits="ClientSessionDemo.WebForm2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>

            Receive Query String:&nbsp;
            <asp:TextBox ID="qryStrResult" runat="server"></asp:TextBox>
&nbsp;
            <asp:Button ID="getDataBtn" runat="server" Text="Get Data" OnClick="GetDataBtn_Click" />

        </div>
    </form>
</body>
</html>
