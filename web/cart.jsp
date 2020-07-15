<%-- 
    Document   : cart
    Created on : Jun 26, 2020, 11:15:07 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <%@ include file="CheckLogin.jsp" %>
        <%@ include file="Header.jsp" %>
        <div class="back-to-shop">
            <a href="index">
                <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                <strong>Back to shopping</strong>
            </a>
        </div>  
        <!--Section: Block Content-->
        <section class="cart-body">
            <!--Grid row-->
            <div class="row">
                <!--Grid column-->
                <div class="col-lg-8">
                    <!-- Card -->
                    <s:if test="#session.cart != null">
                        <h5 class="mb-4 title-cart">Cart (<span><s:property value="products.size()"/></span> items)</h5>
                        <s:iterator value="products">
                            <div class="mb-3">
                                <div class="pt-4 wish-list">
                                    <hr class="mb-4">
                                    <div class="row mb-4">
                                        <div class="col-md-5 col-lg-3 col-xl-3">
                                            <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                                                <img class="img-fluid w-100"
                                                     src="<s:property value="key.img"/>" alt="Sample">
                                            </div>
                                        </div>
                                        <div class="col-md-7 col-lg-9 col-xl-9">
                                            <div>
                                                <div class="d-flex justify-content-between">
                                                    <div>
                                                        <h5><s:property value="key.name"/></h5>
                                                        <p class="mb-3 text-muted text-uppercase small"><s:property value="key.category"/></p>
                                                    </div>
                                                    <div>
                                                        <div class="def-number-input number-input safari_only mb-0 w-100">
                                                            <input class="quantity" min="0" name="quantity" value="<s:property value="value"/>" type="number" disabled="true">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="d-flex justify-content-between align-items-center">
                                                    <div>
                                                        <s:url id="removeid" action="removecart" >
                                                            <s:param name="pid"><s:property value="key.pid"/></s:param>
                                                        </s:url>
                                                        <s:a href="%{removeid}" type="button" class="card-link-secondary small text-uppercase mr-3"><i
                                                                class="fas fa-trash-alt mr-1"></i> Remove item </s:a>
                                                        </div>
                                                        <p class="mb-0"><span><strong>$<s:property value="key.price"/></strong></span></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </s:iterator>
                    </s:if>
                    <s:if test="#session.cart == null">
                        <h3 style="color:black; text-align: center;"><b>CART IS EMPTY!</b></h3>
                    </s:if>

                    <!-- Card -->
                    <div class="mb-3">
                        <div class="pt-4">
                            <h5 class="mb-4">Expected shipping delivery</h5>
                            <p class="mb-0"> Thu., 12.03. - Mon., 16.03.</p>
                        </div>
                    </div>
                    <!-- Card -->

                    <!-- Card -->
                    <div class="mb-3">
                        <div class="pt-4">

                            <h5 class="mb-4">We accept</h5>

                            <img class="mr-2" width="45px"
                                 src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
                                 alt="Visa">
                            <img class="mr-2" width="45px"
                                 src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
                                 alt="American Express">
                            <img class="mr-2" width="45px"
                                 src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
                                 alt="Mastercard">
                            <img class="mr-2" width="45px"
                                 src="https://mdbootstrap.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png"
                                 alt="PayPal acceptance mark">
                        </div>
                    </div>
                    <!-- Card -->

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4">

                    <!-- Card -->
                    <div class="mb-3">
                        <div class="pt-4">

                            <h5 class="mb-3">The total amount of</h5>

                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                    Shipping
                                    <span>Viet Nam</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                    <div>
                                        <strong>The total amount of</strong>
                                        <strong>
                                            <p class="mb-0">(including VAT)</p>
                                        </strong>
                                    </div>
                                    <s:if test="#session.cart == null">
                                        <span><strong>$0</strong></span>
                                    </s:if>
                                    <s:if test="#session.cart != null">
                                        <span><strong>$<s:property value="total"/></strong></span>
                                    </s:if>
                                </li>
                            </ul>
                            <s:url id="buyall" action="buyproduct" >
                                <s:param name="userid">
                                <s:property value="%{#session.user.userid}"/>
                                </s:param>
                            </s:url>
                            <s:if test="#session.cart != null">
                             <s:a href="%{buyall}" type="button" class="btn btn-primary btn-block">Check out</s:a>
                            </s:if>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Grid row -->

        </section>
        <!--Section: Block Content-->
    </body>
</html>
