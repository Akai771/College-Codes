<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie Example with Expiry</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            int count = 0;
            Cookie[] cookies = request.getCookies();
            Cookie visitCookie = null;

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("abc")) {
                        visitCookie = cookie;
                        break;
                    }
                }
            }

            if (visitCookie == null) {
                // First visit
                count = 1;
                visitCookie = new Cookie("abc", String.valueOf(count));
                
            } else {
                // Returning visit
                count = Integer.parseInt(visitCookie.getValue());
                count++;
                visitCookie.setValue(String.valueOf(count));
            }
            
            // set cookie expiry time (in second)
            // 600 = 10 minutes | 86400 = 1 day
            visitCookie.setMaxAge(6); // expiry after 6 seconds
            
            // add updated cookie to response
            response.addCookie(visitCookie);
        %>
        
        <h2>You have visited this page <%= count %></h2>
        <p>(Cookie will reset after 6 seconds of inactivity.)</p>
    </body>
</html>