using System;
using System.Data;
using System.Data.SqlClient;

namespace StoredP
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        SqlConnection con;
        SqlCommand cmd;

        protected void Page_Load(object sender, EventArgs e)
        {
            con = new SqlConnection(
                @"Data Source=(LocalDB)\MSSQLLocalDB; 
                    AttachDbFilename=C:\Users\admin\source\repos\StoredP\StoredP\App_Data\Database1.mdf;
                    Integrated Security=True"
            );
        }

        // INSERT USING STORED PROCEDURE
        protected void InsertClick(object sender, EventArgs e)
        {
            con.Open();

            cmd = new SqlCommand("sp_register", con);
            cmd.CommandType = CommandType.StoredProcedure;

            // PARAMETERS
            cmd.Parameters.AddWithValue("@username", username.Text);
            cmd.Parameters.AddWithValue("@email", email.Text);
            cmd.Parameters.AddWithValue("@password", password.Text);

            cmd.ExecuteNonQuery();

            con.Close();

            Response.Write("Record inserted Successfully");
        }

        // DISPLAY DATA
        protected void ShowClick(object sender, EventArgs e)
        {
            SqlDataAdapter da = new SqlDataAdapter("sp_showUsers", con);
            da.SelectCommand.CommandType = CommandType.StoredProcedure;

            DataSet ds = new DataSet();

            da.Fill(ds);

            GridView1.DataSource = ds;
            GridView1.DataBind();
        }
    }
}