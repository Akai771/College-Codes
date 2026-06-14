using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ClientSessionDemo
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void GetDataBtn_Click(object sender, EventArgs e)
        {
            string data = Request.QueryString["data"].ToString();
            qryStrResult.Text = data;
        }
    }
}