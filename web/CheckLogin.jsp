<%-- 
    Document   : CheckLogin
    Created on : Jun 27, 2020, 9:49:18 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <s:if test="#session.user == null">
              <jsp:forward page="Login.jsp" >
                  <jsp:param name="msg" value="You must login first!" ></jsp:param>
              </jsp:forward>  
           </s:if>
    </body>
</html>
