<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="AJAXControls.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h2>AJAX Controls Demo</h2>

            <!-- User Input Section -->
            Enter Name:&nbsp;
            <asp:TextBox ID="txtName" runat="server"></asp:TextBox>

            <br />
            <br />
            Enter Email:&nbsp;
            <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
            <br />
            <br />
            Enter Phone:&nbsp;
            <asp:TextBox ID="txtPhone" runat="server"></asp:TextBox>

            <br />
            <br />
            <asp:Button ID="btnSubmit" runat="server" Text="Submit" OnClick="BtnSubmit_Click" />

            <br />
            <br />

            <!-- Output Label -->
            <asp:Label ID="lblOutput" runat="server"></asp:Label>

            <br />
            <br />

            <!-- AJAX Controls -->
            <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

            <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                <ContentTemplate>

                    <h3>Current Time (Auto Update using AJAX)</h3>

                    <!-- Timer -->
                    <asp:Timer ID="Timer1" runat="server" Interval="1000" OnTick="Timer1_Tick"></asp:Timer>

                    <asp:Panel ID="Panel1" runat="server" Width="200px" Height="70px" BackColor="LightBlue">
                        <asp:Label ID="Label1" runat="server"></asp:Label>
                    </asp:Panel>
                </ContentTemplate>
            </asp:UpdatePanel>
        </div>
    </form>
</body>
</html>
