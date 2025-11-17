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
            String name = request.getParameter("name");
            int phone = Integer.parseInt(request.getParameter("phone"));
            
            String insert = request.getParameter("insert");
            String display = request.getParameter("display");
            String delete = request.getParameter("delete");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                
                if (insert != null) {
                    PreparedStatement ps = con.prepareStatement("insert into telephone values(?, ?);");
                    ps.setString(1, name);
                    ps.setInt(2, phone);
                    
                    int res = ps.executeUpdate();
                    
                    out.println(res + " Row inserted.");
                }
                
                if (display != null) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from telephone;");
                    
                    while (rs.next()) {                        
                        out.println(rs.getString(1));
                        out.println(rs.getInt(2));
                        out.print("<br>");
                    }
                }
                
                if (delete != null) {
                    PreparedStatement ps = con.prepareStatement("delete from telephone where name = ?;");
                    ps.setString(1, name);
                    
                    int res = ps.executeUpdate();
                    
                    out.println(res + " record deleted");
                }
                
            } catch (Exception e) {
                
            }
        %>
    </body>
</html>
