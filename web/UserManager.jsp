<%-- 
    Document   : UserManager
    Created on : Jun 28, 2020, 6:35:45 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager</title>
    </head>
    <body>
           <%@ include file="Header.jsp" %>
           <h2 style="text-align:center;">Users</h2>
        <table class="table">
            <a href="AddUser.jsp" style="font-size: 1.2rem;"><b>+Add user</b></a>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col"> Username</th>
            <th scope="col"> Password</th>
            <th scope="col"> Role</th>
          </tr>
        </thead>
        <tbody>
            <s:iterator value="users" status="c">
                <s:form action="updateuser" theme="simple">
                <tr>
                    <s:hidden name="userid" value="%{userid}"/>
                  <th scope="row"><s:property value="userid"/></th>
                  <td><s:property value="username"/></td>
                  <td><s:textfield value="%{password}" name="password"/></td>
                  <td>
                      <s:if test="%{role==1}">
                        <label class="radio-inline"><input type="radio" name="role" value="1" checked>User</label>
                        <label class="radio-inline"><input type="radio" name="role" value="2" >Admin</label>
                      </s:if>
                      <s:if test="%{role==2}">
                        <label class="radio-inline"><input type="radio" name="role" value="1" >User</label>
                        <label class="radio-inline"><input type="radio" name="role" value="2" checked>Admin</label>
                      </s:if>
                  <td>                      
                      <s:submit cssClass="btn btn-primary" value="Update"/> 
                      -
                      <s:url id="delete" action="deleteuser">
                            <s:param name="userid" value="userid"/>
                       </s:url>
                      <s:a href="%{delete}" cssStyle="color:red;">Delete</s:a>
                  </td>
                </tr>
                </s:form>
            </s:iterator>
        </tbody>
      </table>
    </body>
</html>
