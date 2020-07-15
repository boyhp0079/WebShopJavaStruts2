<%-- 
    Document   : index
    Created on : Jun 26, 2020, 1:44:29 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head> 
    <body>
        <%@ include file="Header.jsp" %>
        <!--Section: Block Content-->
        <div class="categrory-bar">
            <ul>
                <li>
                    <s:a action="index" >All</s:a>
                    </li>
                    <s:iterator value="CategoryList" var="s" status="c">
                    <s:if test="%{#s.equalsIgnoreCase(category)}">
                        <li class="active-cate">
                            <s:url id="cat" action="index" >
                                <s:param name="category" >
                                    <s:property value="s"/>
                                </s:param>
                            </s:url>
                            <s:a href="%{cat}" ><s:property value="s"/></s:a>
                            </li>
                    </s:if>
                    <s:else>
                        <li class="">
                            <s:url id="cat" action="index" >
                                <s:param name="category" >
                                    <s:property value="s"/>
                                </s:param>
                            </s:url>
                            <s:a href="%{cat}" ><s:property value="s"/></s:a>
                            </li>
                    </s:else>
                </s:iterator>
                <li>
                    <s:form action="findproducts" theme="simple">
                        <s:textfield name="searchString" label="Search by name" value="%{category}" cssClass="search-box"/>
                        <button type="submit" class="btn btn-warning">Find</button>
                    </s:form>
                </li>

            </ul>
        </div>
        <section class="shop-container">
            <!-- Grid row -->
            <div class="row">
                <!-- Grid column -->
                <s:iterator value="ProductList" var="p">
                    <div class="col-md-4 mb-4">
                        <!-- Card -->
                        <div class="">
                            <div class="view zoom overlay z-depth-2 rounded">
                                <img class="img-fluid w-100"
                                     src="<s:property value="img"/>" alt="<s:property value="name"/>" >
                                <a href="#!">
                                </a>
                            </div>
                            <div class="text-center pt-4">
                                <h5><s:property value="name"/></h5>
                                <p class="mb-2 text-muted text-uppercase small"><s:property value="category"/></p>
                                <hr>
                                <h6 class="mb-3"> <s:property value="price"/> $</h6>
                                <div class="btn btn-primary btn-sm mr-1 mb-2"><i
                                        class="fas fa-shopping-cart pr-2" ></i>
                                    <s:url id="getItem" action="item" >
                                        <s:param name="pid"><s:property value="pid"/></s:param>
                                    </s:url>
                                    <s:a href="%{getItem}" cssStyle="color:white;">Buy this item</s:a>
                                    </div>
                                </div>
                            </div>
                        </div>
                </s:iterator>
            </div>
            <!-- Grid row -->
        </section>
        <!--Section: Block Content-->
        <%@ include file="Footer.jsp" %>
    </body>
</html>
