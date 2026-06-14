<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="DataControls.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="Name"></asp:Label>
&nbsp;&nbsp;
            <asp:TextBox ID="name" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label2" runat="server" Text="City"></asp:Label>
&nbsp;
            <asp:TextBox ID="city" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label3" runat="server" Text="Course"></asp:Label>
&nbsp;
            <asp:TextBox ID="course" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Button ID="insert" runat="server" OnClick="Insert_Click" Text="Insert Data" />
&nbsp;
            <asp:Button ID="show" runat="server" OnClick="Show_Click" Text="Show Data" />
            <br />
            <br />

            <!-- GridView -->
            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
            <br />

            <!-- DataList -->
            <asp:DataList ID="DataList1" runat="server" RepeatColumns="2">
                <ItemTemplate>
                    <%# Eval("Name") %> - <%# Eval("City") %> - <%# Eval("Course") %> <br />
                </ItemTemplate>
            </asp:DataList>
            <br />

            <!-- Repeater -->
            <asp:Repeater ID="Repeater1" runat="server">
                <ItemTemplate>
                    <%# Eval("Name") %> - <%# Eval("City") %> - <%# Eval("Course") %> <br />
                </ItemTemplate>
            </asp:Repeater>
            <br />

            <!-- DetailsView -->
            <asp:DetailsView ID="DetailsView1" runat="server" Height="50px" Width="125px"></asp:DetailsView>
            <br />

            <!-- FormView -->
            <asp:FormView ID="FormView1" runat="server">
                <ItemTemplate>
                    Name: <%# Eval("Name") %> <br />
                    City: <%# Eval("City") %> <br />
                    Course: <%# Eval("Course") %> <br />
                </ItemTemplate>
            </asp:FormView>
            <br />

            <!-- ListView -->
            <asp:ListView ID="ListView1" runat="server">
                <ItemTemplate>
                    <%# Eval("Name") %> - <%# Eval("City") %> - <%# Eval("Course") %> <br />
                </ItemTemplate>
            </asp:ListView>
        </div>
    </form>
</body>
</html>
