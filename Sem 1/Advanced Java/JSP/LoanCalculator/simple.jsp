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

                double si = (p * r * t) / 100;
        %>

        <h3 align="center">Simple Interest</h3>
        <p align="center">Interest: <%= si %></p>
        <p align="center">Total Amount: <%= (p + si) %></p>

        <% } catch(Exception e) { %>
            <jsp:forward page="error.jsp"/>
        <% } %>
        <jsp:include page="footer.jsp"/>
    </body>
</html>