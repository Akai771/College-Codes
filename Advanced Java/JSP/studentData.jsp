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
            int rollNo = Integer.parseInt(request.getParameter("rollNo"));
            String name = request.getParameter("sname");
            String course = request.getParameter("course");
            String sem = request.getParameter("sem");

            String insert = request.getParameter("insert");
            String display = request.getParameter("display");
            String delete = request.getParameter("delete");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                
                if (insert != null) {
                    PreparedStatement ps = con.prepareStatement("insert into testing values(?, ?, ?, ?);");
                    ps.setInt(1, rollNo);
                    ps.setString(2, name);
                    ps.setString(3, course);
                    ps.setString(4, sem);

                    int res = ps.executeUpdate();

                    out.println(res + " Row inserted.");
                }

                if (display != null) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from testing;");

                    while (rs.next()) {
                        out.println(rs.getInt(1));
                        out.println(rs.getString(2));
                        out.println(rs.getString(3));
                        out.println(rs.getString(4));
                        out.print("<br>");
                    }
                }

                if (delete != null) {
                    PreparedStatement ps = con.prepareStatement("delete from testing where rollNo = ?;");
                    ps.setInt(1, rollNo);

                    int res = ps.executeUpdate();

                    out.println(res + " record deleted");
                }

            } catch (Exception e) {

            }
        %>
    </body>
</html>