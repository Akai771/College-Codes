<%-- JSP Directive --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Demonstration</title>
    </head>
    <body>

        <!-- JSP Header Section (Static Content) -->
        <header>
            <h1>Welcome to JSP Demonstration</h1>
            <p>This page demonstrates JSP declaration, scriptlet, directive, expression, header, and footer.</p>
        </header>

        <!-- JSP Declaration -->
        <%!
            // JSP Declaration (Declaring a method that returns a greeting)
            public String getGreetingMessage() {
                return "Hello, this is a JSP demo!";
            }
        %>

        <!-- JSP Scriptlet -->
        <%
            // JSP Scriptlet (Embedding Java code inside HTML)
            String user = "John Doe";
            int userAge = 25;
        %>

        <!-- JSP Expression (Displaying a value in the output) -->
        <p><strong>Greeting Message:</strong> <%= getGreetingMessage()%></p>
        <p><strong>User:</strong> <%= user%> (<%= userAge%> years old)</p>

        <!-- Using JSP Expressions to show dynamic content -->
        <p>Current Date and Time: <%= new java.util.Date()%></p>

        <!-- Displaying user-specific content dynamically -->
        <p><strong>User Profile</strong></p>
        <p><%= user%> is <%= userAge%> years old and is learning JSP!</p>

        <!-- JSP Footer Section (Static Content) -->
        <footer>
            <p>&copy; 2025 JSP Demo. All rights reserved.</p>
        </footer>

    </body>
</html>
