using System;
using System.Data;
using System.Data.SqlClient;

namespace DataControls
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        string str = @"Data Source=(LocalDB)\MSSQLLocalDB;
                        AttachDbFilename=|DataDirectory|\Database1.mdf;
                        Integrated Security=True";

        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        // INSERT DATA
        protected void Insert_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(str);

            string qry = "insert into DemoData values('" + name.Text + "', '" + city.Text + "', '" + course.Text + "')";

            SqlCommand cmd = new SqlCommand(qry, con);

            con.Open();
            cmd.ExecuteNonQuery();
            con.Close();

            Response.Write("Data Inserted Successfully");
        }

        // SHOW DATA IN ALL CONTROLS
        protected void Show_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(str);

            SqlDataAdapter da = new SqlDataAdapter("select * from DemoData", con);

            DataSet ds = new DataSet();
            da.Fill(ds);

            // Bind all controls

            GridView1.DataSource = ds;
            GridView1.DataBind();

            DataList1.DataSource = ds;
            DataList1.DataBind();

            Repeater1.DataSource = ds;
            Repeater1.DataBind();

            DetailsView1.DataSource = ds;
            DetailsView1.DataBind();

            FormView1.DataSource = ds;
            FormView1.DataBind();

            ListView1.DataSource = ds;
            ListView1.DataBind();
        }
    }
}