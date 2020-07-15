<%-- 
    Document   : MyProfile
    Created on : Jun 28, 2020, 5:02:22 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
    </head>
    <body>
          <%@ include file="Header.jsp" %>
          <div class="nav-top-ex">
               <s:url id="gethis" action="getbuyloguser">
                        <s:param name="userid" value="userid"/>
                </s:url>
              <s:a href="%{gethis}" class="btn btn-warning">My History <i class="fa fa-shopping-basket" aria-hidden="true"></i></s:a>
          </div>
        <div class="profile-container">
        <div class="card mx-xl-5">
          <!-- Card body -->
          <div class="card-body">
            <!-- Default form subscription -->
            <form action="updateprofile" method="post">
              <p class="h4 text-center py-4"><i class="fa fa-id-card" aria-hidden="true"></i>Update Profile</p>
                <h6 class="error-msg"><s:property value="msg"/></h6>
                <h6 class="error-msg">${param.msg}</h6>
              <!-- Default input name -->
              <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Your ID</label>
              <input name="userid"  value="<s:property value="userid"/>" type="text" id="defaultFormCardNameEx" class="form-control" disabled="true">
              <br>
              <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Your UserName</label>
              <input name="username" value="<s:property value="username"/>" type="text" id="defaultFormCardNameEx" class="form-control" disabled="true">
              <br>
              <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Your Password</label>
              <input name="password" value="<s:property value="password"/>" type="text" id="defaultFormCardNameEx" class="form-control" >
               <br>
              <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Role:  </label>
               <s:if test="%{role==1}">
                   <label class="radio-inline"><input type="radio" name="role" value="1" checked disabled="true">User</label>
                        -
                        <label class="radio-inline"><input type="radio" name="role" value="2" disabled="true">Admin</label>
                      </s:if>
                      <s:if test="%{role==2}">
                        <label class="radio-inline"><input type="radio" name="role" value="1" disabled="true">User</label>
                        -
                        <label class="radio-inline"><input type="radio" name="role" value="2" disabled="true" checked>Admin</label>
                </s:if>
              <div class="text-center py-4 mt-3">
                <button class="btn btn-outline-purple btn-primary" type="submit">Update<i
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
