<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loan Calculator</title>
    </head>
    <body>
        <%
            String type = request.getParameter("type");
            if(type.equals("simple")) {
        %>
            <jsp:forward page="simple.jsp"/>
        <% } else if(type.equals("compound")) { %>
            <jsp:forward page="compound.jsp"/>
        <% } else { %>
            <jsp:forward page="error.jsp"/>
        <% } %>
    </body>
</html>