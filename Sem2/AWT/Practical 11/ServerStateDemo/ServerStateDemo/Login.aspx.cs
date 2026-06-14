using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ServerStateDemo
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void BtnLogin_Click(object sender, EventArgs e)
        {
            if (txtUser.Text == "admin" && txtPassword.Text == "123")
            {
                // SESSION (per user)
                Session["username"] = txtUser.Text;

                // APPLICATION (global count)
                Application.Lock();
                Application["users"] = Convert.ToInt32(Application["users"]) + 1;
                Application.UnLock();

                Response.Redirect("Home.aspx");
            }
            else
            {
                Response.Write("Invalid Login");
            }
        }
    }
}