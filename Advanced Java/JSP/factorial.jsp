<%-- 
    Document   : fact
    Created on : 5 Nov 2025, 3:59:06 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorial Page</title>
    </head>
    <body>
        <h1>Result is</h1>
        <h1>
            <%
                int num1 = Integer.parseInt(request.getParameter("n1"));
                int result = 1;
                if (num1 == 0) {
                    out.println("1");
                } else {
                    for (int i = 1; i <= num1; i++) {
                        result *= i;
                    }
                    out.println(result);
                }
            %>
    </body>
</html>