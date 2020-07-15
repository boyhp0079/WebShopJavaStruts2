<%-- 
    Document   : Login.jsp
    Created on : Jun 27, 2020, 7:52:59 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
                <!--<img src="images/myfirstitem.jpg" width="500px">-->
        <div class="login-form">
            <form action="login" method="POST">
                <h2 class="text-center">Log in</h2>
                <h6 class="error-msg"><s:property value="msg"/></h6>
                <h6 class="error-msg">${param.msg}</h6>
                <div class="form-group">
                    <input name="username" type="text" class="form-control" placeholder="Username" required="required">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="Password" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>
                <div class="clearfix">
                    <a href="#" class="pull-right">Forgot Password?</a>
                </div>        
            </form>
            <p class="text-center"><a href="Resgister.jsp">Create an Account</a></p>
        </div>
    </body>
</html>
