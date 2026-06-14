using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AJAXControls
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Button Click Event
        protected void BtnSubmit_Click(object sender, EventArgs e)
        {
            lblOutput.Text = "Name: " + txtName.Text +
                             "<br>Email: " + txtEmail.Text +
                             "<br>Phone: " + txtPhone.Text;
        }

        // Timer Event (AJAX Refresh)
        protected void Timer1_Tick(object sender, EventArgs e)
        {
            Label1.Text = DateTime.Now.ToLongTimeString();
        }
    }
}