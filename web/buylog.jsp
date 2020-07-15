<%-- 
    Document   : buylog
    Created on : Jun 29, 2020, 4:11:53 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <h2 style="text-align:center;">HISTORY LOG</h2>
        <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">UserName</th>
            <th scope="col">ProductName</th>
            <th scope="col">Amount</th>
            <th scope="col">Total</th>
            <th scope="col">Buy date</th>
          </tr>
        </thead>
        <tbody>
            <s:iterator value="buylogs" status="c">
                <tr>
                  <th scope="row"><s:property value="%{#c.count}"/></th>
                    <td><s:property value="username" /></td>
                    <td><s:property value="name" /></td>
                    <td><s:property value="amount"/></td>
                    <td><s:property value="total"/></td>
                    <td><s:property value="buydate"/></td>
                </tr>
            </s:iterator>
        </tbody>
        </table>
    </body>
</html>
