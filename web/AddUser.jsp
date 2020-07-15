<%-- 
    Document   : AddUser
    Created on : Jun 28, 2020, 8:19:17 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add user</title>
    </head>
    <body>
                  <%@ include file="Header.jsp" %>

        <div class="profile-container">
        <div class="card mx-xl-5">
          <!-- Card body -->
          <div class="card-body">
            <!-- Default form subscription -->
            <form action="adduser" method="post">
              <p class="h4 text-center py-4"><i class="fa fa-id-card" aria-hidden="true"></i>Add User</p>
              <!-- Default input name -->
              <label for="defaultFormCardNameEx" class="grey-text font-weight-light">User Name</label>
              <input name="username"  type="text" id="defaultFormCardNameEx" class="form-control" >
              <br>
              <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Password</label>
              <input name="password" type="text" id="defaultFormCardNameEx" class="form-control" >
              <br>
              <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Role:  </label>
                    <label class="radio-inline"><input type="radio" name="role" value="1" checked>User</label>
                    -
                    <label class="radio-inline"><input type="radio" name="role" value="2" >Admin</label>
              <div class="text-center py-4 mt-3">
                <button class="btn btn-outline-purple btn-primary" type="submit">Add<i
                    class="fa fa-paper-plane-o ml-2"></i></button>
              </div>
            </form>
            <!-- Default form subscription -->
          </div>
          <!-- Card body -->
        </div>
        <!-- Card -->
        </div>
        <%@ include file="Footer.jsp" %>
    </body>
</html>
