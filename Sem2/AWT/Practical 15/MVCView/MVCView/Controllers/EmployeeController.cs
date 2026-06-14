using MVCView.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCView.Controllers
{
    public class EmployeeController : Controller
    {
        // GET: Employee
        public ActionResult Index()
        {
            Employee emp = new Employee();
            emp.eid = 101;
            emp.ename = "Ram";
            emp.department = "IT";
            emp.salary = 45000;

            return View(emp);
        }
    }
}