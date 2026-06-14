<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loan Calculator</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <%
            try {
                double p = Double.parseDouble(request.getParameter("amount"));
                int t = Integer.parseInt(request.getParameter("years"));
                double r = 5;

                double amount = p * Math.pow((1 + r / 100), t);
                double ci = amount - p;
        %>
        <h3 align="center">Compound Interest</h3>
        <p align="center">Interest: <%= ci %></p>
        <p align="center">Total Amount: <%= amount %></p>
        <% } catch(Exception e) { %>
            <jsp:forward page="error.jsp"/>
        <% } %>
        <jsp:include page="footer.jsp"/>

    </body>
</html>