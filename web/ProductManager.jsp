<%-- 
    Document   : ProductManager
    Created on : Jun 28, 2020, 6:36:10 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product manager</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <h2 style="text-align:center;">Products<s:iterator value="categoryList" var="cate"><s:property value="cate"/></s:iterator></h2>
        <a href="addproductview" style="font-size: 1.2rem;"><b>+Add Product</b></a>
        <table class="table">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col"> Name</th>
            <th scope="col"> Type</th>
            <th scope="col"> price</th>
            <th scope="col"> Image</th>
            <th scope="col"> Action</th>
          </tr>
        </thead>
        <tbody>
            <s:iterator value="products" >
                <s:form action="updateproduct" theme="simple">
                <tr>
                    <s:hidden name="pid" value="%{pid}" />
                  <th scope="row"><s:property value="pid"/></th>
                  <td><s:textfield value="%{name}" name="name" cssStyle="width:100px;"/></td>
                    <td>
                        <select name="category" >
                            <s:iterator value="[1].categoryList" var="cate" status="c">
                                <s:if test="%{#cate.equalsIgnoreCase(category)}">
                                    <option value="<s:property value="cate"/>" selected="true"><s:property value="cate"/></option>
                                 </s:if>
                                 <s:else>
                                    <option value="<s:property value="cate"/>"><s:property value="cate"/></option>
                                 </s:else>
                            </s:iterator>
                        </select>
                      </td>
                      <td><s:textfield value="%{price}" name="price" cssStyle="width:70px;"/></td>
                      <td><s:textfield value="%{img}" name="img"/></td>
                  <td>                      
                      <s:submit cssClass="btn btn-primary" value="Update"/>   
                      <s:url id="delete" action="deleteproduct">
                            <s:param name="pid" value="pid"/>
                       </s:url>
                      -
                      <s:a href="%{delete}" cssStyle="color:red;">Delete</s:a>
                  </td>
                </tr>
                </s:form>
            </s:iterator>
        </tbody>
      </table>
    </body>
</html>
