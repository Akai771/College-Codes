<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Loan Calculator</title>
  </head>
  <body>
    <jsp:include page="header.jsp" />

    <h3 align="center">Loan Calculator</h3>

    <form action="controller.jsp" method="post" align="center">
      Loan Amount:
      <input type="text" name="amount" /><br /><br />

      Years:
      <input type="text" name="years" /><br /><br />

      Interest Type:
      <select name="type">
        <option value="simple">Simple Interest</option>
        <option value="compound">Compound Interest</option></select
      ><br /><br />

      <input type="submit" value="Calculate" />
    </form>

    <jsp:include page="footer.jsp" />
  </body>
</html>
