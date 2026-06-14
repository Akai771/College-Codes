using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

namespace WFCon
{
    public partial class WebForm1 : System.Web.UI.Page
    {

        SqlConnection con;
        SqlCommand cmd;
        SqlDataReader dr;

        protected void Page_Load(object sender, EventArgs e)
        {
            con = new SqlConnection(
                    @"Data Source = (LocalDB)\MSSQLLocalDB; 
                      AttachDbFilename = C:\Users\admin\source\repos\WFCon\WFCon\App_Data\Database1.mdf; 
                      Integrated Security = True"
                );

            con.Open();
        }

        // SELECT
        protected void Select_Click(Object sender, EventArgs e)
        {
            cmd = new SqlCommand("select * from student where sroll='" + roll.Text + "'", con);

            dr = cmd.ExecuteReader();

            if (dr.Read())
            {
                lname.Text = "Name: " + dr[0].ToString();
                lroll.Text = "Roll No: " + dr[1].ToString();
                laddress.Text = "Address: " + dr[2].ToString();
                lcontact.Text = "Contact: " + dr[3].ToString();
            }
        }

        // INSERT
        protected void Insert_Click(Object sender, EventArgs e)
        {
            string qry = "insert into student values ('" + name.Text + "', '" + roll.Text + "', '" + address.Text + "', '" + contact.Text + "')";
            cmd = new SqlCommand(qry, con);
            cmd.ExecuteNonQuery();
        }

        // UPDATE
        protected void Update_Click(Object sender, EventArgs e)
        {
            string qry = "update student set scont='" + contact.Text + "' where sroll='" + roll.Text + "'";
            cmd = new SqlCommand(qry, con);
            cmd.ExecuteNonQuery();
        }

        // DELETE
        protected void Delete_Click(Object sender, EventArgs e)
        {
            string qry = "delete from student where sroll='" + roll.Text + "'";
            cmd = new SqlCommand(qry, con);
            cmd.ExecuteNonQuery();
        }

        // CLEAR
        protected void Clear_Click(Object sender, EventArgs e)
        {
            name.Text = "";
            roll.Text = "";
            address.Text = "";
            contact.Text = "";

        }

        // SHOW ALL
        protected void Show_Click(Object sender, EventArgs e)
        {
            cmd = new SqlCommand("select * from student", con);

            dr = cmd.ExecuteReader();

            GridView1.DataSource = dr;
            GridView1.DataBind();

            dr.Close();
        }
    }
}