using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RegistrationForm
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // Button Click Event
        protected void BtnSubmit(object sender, EventArgs e)
        {
            if (Page.IsValid)
            {


                // 1. Get TextBox Values
                string name = this.name.Text;
                string email = this.email.Text;
                string password = this.password.Text;

                // 2. Gender (RadioButton)
                string gender = this.gender.SelectedValue;

                /* if (male.Checked)
                {
                    gender = "Male";
                }

                if (female.Checked)
                {
                    gender = "Female";
                }
                */
                // 3. Course (CheckBox - Multiple)
                string course = "";

                if (java.Checked)
                {
                    course += "Java ";
                }

                if (python.Checked)
                {
                    course += "Python ";
                }

                if (asp.Checked)
                {
                    course += "ASP.Net ";
                }

                // 4. Department (Dropdown)

                string depName = dep.SelectedValue;

                // 5. Date of Birth (Calendar)
                string dob;

                if (this.dob.SelectedDate != DateTime.MinValue)
                {
                    dob = this.dob.SelectedDate.ToShortDateString();
                }
                else
                {
                    dob = "not selected";
                }

                // 6. File Upload
                string fileName;

                if (file.HasFile)
                {
                    fileName = file.FileName;

                    // Create path
                    string path = Server.MapPath("~/Uploads/") + fileName;

                    // Save file
                    file.SaveAs(path);
                }
                else
                {
                    fileName = "No file uploaded";
                }

                // 7. Display Output
                result.Text = "<b>Registration Successful!</b> <br/> <br/>" +
                              "Name: " + name + "<br/>" +
                              "Email: " + email + "<br/>" +
                              "Gender: " + gender + "<br/>" +
                              "Course: " + course + "<br/>" +
                              "Department: " + depName + "<br/>" +
                              "DOB: " + dob + "<br/>" +
                              "File: " + fileName;

            }
        }

        protected void gender_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void courseValidate(object source, ServerValidateEventArgs args)
        {
            args.IsValid = python.Checked || java.Checked || asp.Checked;
        }
    }
}