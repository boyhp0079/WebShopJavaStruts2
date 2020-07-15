<%-- 
    Document   : AddProduct
    Created on : Jun 28, 2020, 8:18:57 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add product</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <div class="profile-container">
            <div class="card mx-xl-5">
                <!-- Card body -->
                
                <div class="card-body">
                    <!-- Default form subscription -->
                    <form action="addproduct" method="post">
                        <p class="h4 text-center py-4"><i class="fa fa-shopping-basket" aria-hidden="true"></i>Add Product</p>
                        <!-- Default input name -->
                        <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Product Name</label>
                        <input name="name" type="text" id="defaultFormCardNameEx" class="form-control" >
                        <br>
                        <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Product Image</label>
                        <input name="img"  type="text" id="defaultFormCardNameEx" class="form-control" >
                        <br>
                        <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Price</label>
                        <input name="price" type="text" id="defaultFormCardNameEx" class="form-control" >
                        <br>
                        <label for="defaultFormCardNameEx" class="grey-text font-weight-light">Category</label>
                        <select name="category" >
                            <s:iterator value="categoryList" var="cate">
                                <option value="<s:property value="cate"/>"><s:property value="cate"/></option>
                            </s:iterator>
                        </select>
                        <div class="text-center py-4 mt-3">
                            <button class="btn btn-outline-purple btn-primary" type="submit">Add Product<i
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
