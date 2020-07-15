<%-- 
    Document   : Login.jsp
    Created on : Jun 27, 2020, 7:52:59 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <div class="login-form">
            <form action="signup" method="post">
                <h2 class="text-center">Sign up</h2>      
                <h6 class="error-msg"><s:property value="msg"/></h6>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" name="username" class="form-control" placeholder="Username" required="required" id="username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password" required="required" id="password">
                </div>
                <div class="form-group">
                    <label for="password2">re-input Password</label>
                    <input id="password2" type="password" class="form-control" name="password2" placeholder="ReInput Password" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Create Account</button>
                </div>

            </form>
            <p class="text-center"><a href="#">Login</a></p>
        </div>
    </body>
</html>
