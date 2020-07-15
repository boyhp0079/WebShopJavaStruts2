<%-- 
    Document   : Header
    Created on : Jun 26, 2020, 1:43:58 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
        <link href="fontawesome-free-5.13.1-web/css/all.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-md navbar-light">
            <a class="navbar-brand" href="index">
                <img src="images/myotherlogo.jpg" height="80px" alt="my logo">
            </a>

            <!-- Collapse button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav1"
                    aria-controls="basicExampleNav1" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Links -->
            <div class="collapse navbar-collapse" id="basicExampleNav1">

                <!-- Right -->
                <ul class="navbar-nav ml-auto">
                    <s:if test="%{#session.user.role == 2}">
                         <li class="nav-item">
                             <a href="manageusers" class="nav-link waves-effect">
                               Manage all users
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="manageproducts" class="nav-link waves-effect">
                               Manage all Products
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="getbuylogall" class="nav-link waves-effect">
                               See all buy history
                            </a>
                        </li>
                    </s:if>
                    <li class="nav-item">
                        <a href="cart" class="nav-link navbar-link-2 waves-effect">
                            <span class="badge badge-pill red"><s:property value="%{#session.cart.getProducts().size()}" /></span>
                            <i class="fas fa-shopping-cart pl-0"></i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="index" class="nav-link waves-effect">
                            Shop
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="MyFace.jsp" class="nav-link waves-effect">
                            Contact
                        </a>
                    </li>
                    <s:if test="%{#session.logged_in == true}">
                         <li class="nav-item">
                            <a href="getprofile" class="nav-link waves-effect">
                               <b><s:property value="%{#session.user}" /></b>
                            </a>
                        </li>
                        <li class="nav-item">
                            <s:a action="logout" cssClass="nav-link waves-effect" cssStyle="color:red;">Log out</s:a>
                        </li>
                    </s:if>
                    <s:if test="%{#session.logged_in == null}">
                        <li class="nav-item">
                            <a href="Login.jsp" class="nav-link waves-effect">
                                Sign in
                            </a>
                        </li>
                        <li class="nav-item pl-2 mb-2 mb-md-0">
                            <a href="Resgister.jsp" type="button"
                               class="btn btn-outline-info btn-md btn-rounded btn-navbar waves-effect waves-light">Sign up</a>
                        </li>
                    </s:if>

                </ul>
            </div>
            <!-- Links -->

        </nav>
    </body>
</html>
