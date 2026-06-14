using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ServerStateDemo
{
    public partial class Home : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["username"] != null)
            {
                // SESSION DATA
                lblUser.Text = Session["username"].ToString();

                // APPLICATION DATA
                lblUsers.Text = Application["users"].ToString();
                lblHits.Text = Application["hits"].ToString();
            }
            else
            {
                Response.Redirect("Login.aspx");
            }

            // Count hits
            Application.Lock();
            Application["hits"] = Convert.ToInt32(Application["hits"]) + 1;
            Application.UnLock();
        }

        protected void BtnLogout_Click(object sender, EventArgs e)
        {
            Session.Abandon();
            Response.Redirect("Login.aspx");
        }
    }
}