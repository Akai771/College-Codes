using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebService
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void BtnSubmit_Click(object sender, EventArgs e)
        {
            localhost.WebService1 obj = new localhost.WebService1();

            string name = obj.getname(txtName.Text);
            int acc = obj.getaccountnumber(Convert.ToInt32(txtAccount.Text));

            Label1.Text = "Name: " + name;
            Label2.Text = "Account No: " + acc;
        }
    }
}