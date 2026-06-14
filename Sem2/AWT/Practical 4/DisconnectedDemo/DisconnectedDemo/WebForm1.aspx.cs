using System;
using System.Data;
using System.Data.SqlClient;

namespace DisconnectedDemo
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        SqlConnection con;
        SqlDataAdapter da;
        SqlCommand cmd;
        DataSet ds;

        protected void Page_Load(object sender, EventArgs e)
        {
            con = new SqlConnection(
                    @"Data Source = (LocalDB)\MSSQLLocalDB; 
                        AttachDbFilename = C:\Users\admin\source\repos\DisconnectedDemo\DisconnectedDemo\App_Data\Database1.mdf;
                        Integrated Security = True"
                );

        }

        // SELECT (DISCONNECTED) 
        protected void SelectClick(object sender, EventArgs e)
        {
            con.Open();

            da = new SqlDataAdapter("Select * from employee", con);
            ds = new DataSet();

            da.Fill(ds);

            con.Close();

            GridView1.DataSource = ds;
            GridView1.DataBind();
        }

        // INSERT
        protected void InsertClick(object sender, EventArgs e)
        {
            Console.WriteLine(empNo.GetType());
            string qry = "insert into employee values(" + empNo.Text + ", '" + empName.Text + "', '" + empAddress.Text + "', '" + empCont.Text + "')";

            con.Open();

            cmd = new SqlCommand(qry, con);
            cmd.ExecuteNonQuery();

            con.Close();

            Response.Write("Inserted Successfully");
        }

        // UPDATE
        protected void UpdateClick(object sender, EventArgs e)
        {
            string qry = "update employee set ename = '" + empName.Text + "', eadd = '" + empAddress.Text + "', econt = '" + empCont.Text + "' where eno = " + empNo.Text;

            con.Open();

            cmd = new SqlCommand(qry, con);
            cmd.ExecuteNonQuery();

            con.Close();

            Response.Write("Updated Successfully");
        }

        // DELETE
        protected void DeleteClick(object sender, EventArgs e)
        {
            string qry = "delete from employee where eno = " + empNo.Text;

            con.Open();

            cmd = new SqlCommand(qry, con);
            cmd.ExecuteNonQuery();

            con.Close();

            Response.Write("Deleted Successfully");
        }

        // CLEAR
        protected void ClearClick(object sender, EventArgs e)
        {
            empNo.Text = "";
            empName.Text = "";
            empAddress.Text = "";
            empCont.Text = "";
        }
    }
}