using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace LinQ
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        Database1Entities dc = new Database1Entities();

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        public void ShowData()
        {
            GridView1.DataSource = dc.students.ToList();
            GridView1.DataBind();
        }

        // INSERT
        protected void Insert_Click(object sender, EventArgs e)
        {
            student s = new student();

            s.Id = Convert.ToInt32(txtId.Text);
            s.Name = name.Text;
            s.Age = Convert.ToInt32(age.Text);
            s.Div = div.Text;
            s.DreameJob = dreamJob.Text;

            dc.students.Add(s);
            dc.SaveChanges();

            Response.Write("Inserted Successfully");
        }

        // UPDATE
        protected void Update_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(txtId.Text);

            student s = dc.students.Single(x => x.Id == id);

            s.Name = name.Text;
            s.Age = Convert.ToInt32(age.Text);
            s.Div = div.Text;
            s.DreameJob = dreamJob.Text;

            dc.SaveChanges();

            ShowData();
        }

        protected void Delete_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(txtId.Text);

            student s = dc.students.Single(x => x.Id == id);

            dc.students.Remove(s);
            dc.SaveChanges();

            ShowData();
        }

        protected void Select_Click(object sender, EventArgs e)
        {
            ShowData();
        }
    }
}