<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Telephone Directory</title>
    </head>
    <body>
        <%
            // getting input value by using name attribute
            String name = request.getParameter("name");
            int phone = Integer.parseInt(request.getParameter("phone"));

            String insert = request.getParameter("insert");
            String display = request.getParameter("display");
            String delete = request.getParameter("delete");
            try {
                // Loadin mysql jdbc driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // add database name after port i.e 3600/db_name
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
//                out.println("Database Connected...");

                // inserting data into database
                if (insert != null) {
                    PreparedStatement ps = con.prepareStatement("insert into telephone values(?, ?);");
                    ps.setString(1, name);
                    ps.setInt(2, phone);

                    int res = ps.executeUpdate();

                    out.println(res + " Row inserted.");
                }

                // fetching data from database
                if (display != null) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from telephone;");

                    while (rs.next()) {
                        out.println(rs.getString(1));
                        out.println(rs.getInt(2));
                        out.print("<br>");
                    }
                }

                // deleting data from database
                if (delete != null) {
                    PreparedStatement ps = con.prepareStatement("delete from telephone where name = ?;");
                    ps.setString(1, name);

                    int res = ps.executeUpdate();

                    out.println(res + " record deleted");
                }

            } catch (Exception e) {
//                out.println("Database not Connected..." + e);

            }
        %>
    </body>
</html>