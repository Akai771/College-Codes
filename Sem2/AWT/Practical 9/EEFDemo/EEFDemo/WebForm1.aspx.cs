using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EEFDemo
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        Database1Entities db = new Database1Entities();

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        public void ShowData()
        {
            GridView1.DataSource = db.products.ToList();
            GridView1.DataBind();
        }

        // INSERT
        protected void Insert_Click(object sender, EventArgs e)
        {
            product p = new product();

            p.pid = Convert.ToInt32(pid.Text);
            p.pname = name.Text;
            p.pcost = cost.Text;

            db.products.Add(p);
            db.SaveChanges();

            Response.Write("Inserted Successfully");
        }

        // UPDATE
        protected void Update_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(pid.Text);

            product p = db.products.Single(x => x.pid == id);

            p.pname = name.Text;
            p.pcost = cost.Text;

            db.SaveChanges();

            ShowData();
        }

        // DELETE
        protected void Delete_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(pid.Text);

            product p = db.products.Single(x => x.pid == id);

            db.products.Remove(p);
            db.SaveChanges();

            ShowData();
        }

        // SHOW
        protected void Show_Click(object sender, EventArgs e)
        {
            ShowData();
        }
    }
}