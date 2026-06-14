<%@ Page Title="Home Page" Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="RegistrationForm._Default" %>

<!Doctype html>
<html>
<head>
    <style type="text/css">
        .auto-style1 {
            width: 77%;
            height: 256px;
        }
        .auto-style2 {
            width: 507px;
        }
        .auto-style3 {
            width: 507px;
            height: 23px;
        }
        .auto-style4 {
            width: 884px;
        }
        .auto-style5 {
            width: 884px;
            height: 23px;
        }
        .auto-style6 {
            width: 507px;
            height: 26px;
        }
        .auto-style7 {
            width: 884px;
            height: 26px;
        }
    </style>
</head>
<body style="width: 1314px; height: 526px">
<form id="form1" runat="server">
    <asp:ScriptManager ID="ScriptManager1" runat="server" />

    <table class="auto-style1">
        <tr>
            <td class="auto-style2" style="font-size: xx-large; font-weight: bold">Registration Page</td>
            <td class="auto-style4">&nbsp;</td>
        </tr>
        <tr>
            <td class="auto-style3">
                <asp:Label ID="Label1" runat="server" Text="Name"></asp:Label>
            </td>
            <td class="auto-style5">
                <asp:TextBox ID="name" runat="server" Height="28px" Width="148px"></asp:TextBox>
                &nbsp;
                <asp:RequiredFieldValidator ID="nameError" runat="server" ErrorMessage="Name required" ControlToValidate="name" ForeColor="Red">Enter the name</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style2">
                <asp:Label ID="Label2" runat="server" Text="Email"></asp:Label>
            </td>
            <td class="auto-style4">
                <asp:TextBox ID="email" runat="server" Height="28px" Width="147px" TextMode="Email"></asp:TextBox>
                &nbsp;
                <asp:RequiredFieldValidator ID="emailError" runat="server" ErrorMessage="Email required" ControlToValidate="email" ForeColor="Red">Enter the email</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style3">
                <asp:Label ID="Label3" runat="server" Text="Password"></asp:Label>
            </td>
            <td class="auto-style5">
                <asp:TextBox ID="password" runat="server" Height="26px" Width="146px" TextMode="Password"></asp:TextBox>
                &nbsp;
                <asp:RequiredFieldValidator ID="passwordError" runat="server" ErrorMessage="Password required" ControlToValidate="password" ForeColor="Red">Enter the password</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style6">
                <asp:Label ID="Label4" runat="server" Text="Confirm Password"></asp:Label>
            </td>
            <td class="auto-style7">
                <asp:TextBox ID="cpassword" runat="server" Height="26px" Width="144px" TextMode="Password"></asp:TextBox>
                &nbsp;
                <asp:RequiredFieldValidator ID="cpasswordError" runat="server" ErrorMessage="Confirm password required" ControlToValidate="cpassword" ForeColor="Red">Re-Enter the password</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style2">
                <asp:Label ID="Label5" runat="server" Text="Gender"></asp:Label>
            </td>
            <td class="auto-style4">
                <asp:RadioButtonList ID="gender" runat="server" OnSelectedIndexChanged="gender_SelectedIndexChanged" RepeatDirection="Horizontal" Width="207px">
                    <asp:ListItem>Male</asp:ListItem>
                    <asp:ListItem>Female</asp:ListItem>
                </asp:RadioButtonList>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="gender" ErrorMessage="gender required" ForeColor="Red">Select gender</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style3">
                <asp:Label ID="Label6" runat="server" Text="Course"></asp:Label>
            </td>
            <td class="auto-style5">
                <asp:CheckBox ID="java" runat="server" Text="Java" />
&nbsp;
                <asp:CheckBox ID="python" runat="server" Text="Python" />
&nbsp;
                <asp:CheckBox ID="asp" runat="server" Text="ASP.Net" />
            &nbsp;&nbsp;
                <asp:CustomValidator ID="CustomValidator1" runat="server" ErrorMessage="Course required" ForeColor="Red" OnServerValidate="courseValidate">Select at-least one course</asp:CustomValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style2">
                <asp:Label ID="Label7" runat="server" Text="Department"></asp:Label>
            </td>
            <td class="auto-style4">
                <asp:DropDownList ID="dep" runat="server">
                    <asp:ListItem>HR</asp:ListItem>
                    <asp:ListItem>IT</asp:ListItem>
                    <asp:ListItem>Finance</asp:ListItem>
                </asp:DropDownList>
            </td>
        </tr>
        <tr>
            <td class="auto-style2">
                <asp:Label ID="Label8" runat="server" Text="DOB"></asp:Label>
            </td>
            <td>
                <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                     <ContentTemplate>
                        <asp:Calendar ID="dob" runat="server" BackColor="White" BorderColor="#999999" CellPadding="4" DayNameFormat="Shortest" Font-Names="Verdana" Font-Size="8pt" ForeColor="Black" Height="180px" Width="200px">

                        <DayHeaderStyle BackColor="#CCCCCC" Font-Bold="True" Font-Size="7pt" />

                        <NextPrevStyle VerticalAlign="Bottom" />
                        <OtherMonthDayStyle ForeColor="#808080" />
                        <SelectedDayStyle BackColor="#666666" Font-Bold="True" ForeColor="White" />
                        <SelectorStyle BackColor="#CCCCCC" />

                        <TitleStyle BackColor="#999999" BorderColor="Black" Font-Bold="True" />

                        <TodayDayStyle BackColor="#CCCCCC" ForeColor="Black" />
                        <WeekendDayStyle BackColor="#FFFFCC" />
                        </asp:Calendar>
                     </ContentTemplate>
                </asp:UpdatePanel>
            </td>
        </tr>
        <tr>
            <td class="auto-style2">
                <asp:Label ID="Label9" runat="server" Text="Resume"></asp:Label>
            </td>
            <td class="auto-style4">
                <asp:FileUpload ID="file" runat="server" />
            &nbsp;
                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="file" ErrorMessage="No file has been selected" ForeColor="Red">Select a file</asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td class="auto-style2">
                <asp:Button ID="sbmt" runat="server" Height="32px" Text="Submit" Width="83px" OnClick="BtnSubmit" />
            </td>
            <td class="auto-style4">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2">
                <asp:Label ID="result" runat="server"></asp:Label>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
