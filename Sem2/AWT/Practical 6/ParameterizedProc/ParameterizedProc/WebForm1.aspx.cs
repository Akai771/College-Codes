using System;
using System.Data;
using System.Data.SqlClient;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ParameterizedProc
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        string str = @"Data Source=(LocalDB)\MSSQLLocalDB;
                        AttachDbFilename=C:\Users\admin\source\repos\ParameterizedProc\ParameterizedProc\App_Data\Database1.mdf;
                        Integrated Security=True";

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // SHOW DATA
        protected void ShowClick(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(str);

            SqlDataAdapter da = new SqlDataAdapter("select * from UserRegistration", con);

            DataSet ds = new DataSet();

            da.Fill(ds);

            GridView1.DataSource = ds;
            GridView1.DataBind();
        }

        // INSERT
        protected void InsertClick(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(str);

            SqlCommand cmd = new SqlCommand("SpMyProcedure", con);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@Action", "insert");
            cmd.Parameters.AddWithValue("@Name", name.Text);
            cmd.Parameters.AddWithValue("@Age", age.Text);
            cmd.Parameters.AddWithValue("@Country", country.Text);

            con.Open();
            cmd.ExecuteNonQuery();
            con.Close();

            Response.Write("Inserted Successfully");
        }

        // UPDATE
        protected void UpdateClick(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(str);

            SqlCommand cmd = new SqlCommand("SpMyProcedure", con);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@Action", "update");
            cmd.Parameters.AddWithValue("@Id", id.Text);
            cmd.Parameters.AddWithValue("@Name", name.Text);
            cmd.Parameters.AddWithValue("@Age", age.Text);
            cmd.Parameters.AddWithValue("@Country", country.Text);

            con.Open();
            cmd.ExecuteNonQuery();
            con.Close();

            Response.Write("Updated Successfully");
        }

        protected void DeleteClick(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(str);

            SqlCommand cmd = new SqlCommand("SpMyProcedure", con);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@Action", "delete");
            cmd.Parameters.AddWithValue("@Id", id.Text);

            con.Open();
            cmd.ExecuteNonQuery();
            con.Close();

            Response.Write("deleted Successfully");
        }

        protected void ClearClick(object sender, EventArgs e)
        {
            id.Text = "";
            name.Text = "";
            age.Text = "";
            country.Text = "";
        }
    }
}