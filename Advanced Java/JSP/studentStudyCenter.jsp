<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Data!</h1>
        <%
            String rollNo = request.getParameter("rollNo");
            String name = request.getParameter("sname");
            String course = request.getParameter("course");
            String sem = request.getParameter("sem");
            String studyCenter = request.getParameter("center");

            String insert = request.getParameter("insert");
            String update = request.getParameter("update");
            String display = request.getParameter("display");
            String delete = request.getParameter("delete");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                
                if (insert != null) {
                    PreparedStatement ps = con.prepareStatement("insert into students values(?, ?, ?, ?, ?);");
                    ps.setString(1, rollNo);
                    ps.setString(2, name);
                    ps.setString(3, course);
                    ps.setString(4, sem);
                    ps.setString(5, studyCenter);

                    int res = ps.executeUpdate();

                    out.println(res + " Row inserted.");
                }
                
                if (update != null) {
                    PreparedStatement ps = con.prepareStatement("update students set name = ?, course = ?, sem = ?, center = ? where rollno = ?;");
                    ps.setString(1, name);
                    ps.setString(2, course);
                    ps.setString(3, sem);
                    ps.setString(4, studyCenter);
                    ps.setString(5, rollNo);

                    int res = ps.executeUpdate();

                    out.println(res + " Row updated.");
                }

                if (display != null) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from students;");

                    while (rs.next()) {
                        out.println(rs.getString(1));
                        out.println(rs.getString(2));
                        out.println(rs.getString(3));
                        out.println(rs.getString(4));
                        out.println(rs.getString(5));
                        out.print("<br>");
                    }
                }

                if (delete != null) {
                    PreparedStatement ps = con.prepareStatement("delete from students where rollNo = ?;");
                    ps.setString(1, rollNo);

                    int res = ps.executeUpdate();

                    out.println(res + " record deleted");
                }

            } catch (Exception e) {

            }
        %>
    </body>
</html>