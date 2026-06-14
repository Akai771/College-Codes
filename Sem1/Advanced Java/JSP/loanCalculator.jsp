<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loan Calculator</title>
    </head>
    <body style="display: flex;flex-direction: column; align-items: center; justify-content: center">
        <h1>Loan Data</h1>
        <%
            Double loanAmount = Double.parseDouble(request.getParameter("amount"));
            Integer years = Integer.parseInt(request.getParameter("year"));
            double annualInterest = 0;
            
            if(years <= 4)
                annualInterest = 5.45;
            
            else if(years > 4 && years <= 10)
                annualInterest = 6.5;
            
            else if(years > 10 && years <= 15)
                annualInterest = 8.75;
            
            double monthlyInterest = annualInterest / 1200;
            double monthlyPayment = loanAmount * monthlyInterest / (1 - 1 / Math.pow(1 + monthlyInterest, years * 12));
            double totalPayment = monthlyPayment * years * 12;
        %>
        <div style="display: flex; flex-direction: column; align-items: flex-start; justify-content: flex-start; gap: 5px">
            <span>Loan Amount: <%= loanAmount %></span>
            <span>Years: <%= years %></span>
            <span>Annual Interest Rate: <%= annualInterest %></span>
            <span>Monthly Interest Rate: <%= String.format("%.2f", monthlyInterest) %></span>
            <span>Monthly Payments: <%= String.format("%.2f", monthlyPayment) %></span>
            <span>Total Payments: <%= String.format("%.2f", totalPayment) %></span>
        </div>
    </body>
</html>
