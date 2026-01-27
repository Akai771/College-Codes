<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <body>
        <h1>You are successfully Registered</h1>
        <h4>Your details are as follows</h4>
        <%
            String name = request.getParameter("txtName");
            String email = request.getParameter("txtEmail");
            String dob = request.getParameter("txtdate");
            String equalify = request.getParameter("opt-qualify");
            String[] lang = request.getParameterValues("language[]");
            String yourself = request.getParameter("about");
            String gen = request.getParameter("gen");

            out.println("<table border='1' cellpadding='15px' align='center'>");
            out.println("<tr>");
            out.println("<td>");
            out.println("Name");
            out.println("</td>");
            out.println("<td>");
            out.println(name);
            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("Email");
            out.println("</td>");
            out.println("<td>");
            out.println(email);
            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("DOB");
            out.println("</td>");
            out.println("<td>");
            out.println(dob);
            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("Educaional Qualification");
            out.println("</td>");
            out.println("<td>");
            out.println(equalify);
            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("Your self");
            out.println("</td>");
            out.println("<td>");
            out.println(yourself);
            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("Language");
            out.println("</td>");
            out.println("<td>");
            for (String l : lang) {
                out.println(l);
            }
            out.println("</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>");
            out.println("Gender");
            out.println("</td>");
            out.println("<td>");
            out.println(gen);
            out.println("</td>");
            out.println("</tr>");

            out.println("</table>");

        %>
    </body>
</html>