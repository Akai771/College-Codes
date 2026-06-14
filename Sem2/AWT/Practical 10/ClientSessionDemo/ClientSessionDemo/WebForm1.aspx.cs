using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ClientSessionDemo
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // ViewState Save
        protected void SaveBtn_Click(object sender, EventArgs e)
        {
            ViewState["userId"] = userId.Text;
            userId.Text = string.Empty;

            Response.Write("ViewState Created Successfully");
        }

        // ViewState Retrieve
        protected void GetBtn_Click(object sender, EventArgs e)
        {
            if (ViewState["userId"] != null)
            {
                viewStateLable.Text = ViewState["userId"].ToString();
            }
        }

        // Hidden Field Read
        protected void HiddenFieldBtn_Click(object sender, EventArgs e)
        {
            hiddenLable.Text = HiddenField1.Value;
        }

        // Query String Send
        protected void QueryStrBtn_Click(object sender, EventArgs e)
        {
            Response.Redirect("WebForm2.aspx?data=" + queryStr.Text);
        }

        // Cookie Create
        protected void CreateBtn_Click(object sender, EventArgs e)
        {
            Response.Cookies["name"].Value = cookieTxt.Text;
            Response.Cookies["name"].Expires = DateTime.Now.AddMinutes(1);

            cookieLabel.Text = "Cookie Created";
            cookieTxt.Text = "";
        }

        // Cookie Read
        protected void ReadBtn_Click(object sender, EventArgs e)
        {
            if (Request.Cookies["name"] == null)
            {
                cookieTxt.Text = "No Cookie Found";
            }
            else
            {
                cookieTxt.Text = Request.Cookies["name"].Value;
            }
        }
    }
}