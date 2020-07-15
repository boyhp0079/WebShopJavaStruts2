<%-- 
    Document   : ItemDetail
    Created on : Jun 26, 2020, 11:00:18 PM
    Author     : 84911
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Detail</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <div class="back-to-shop">
            <a href="index">
             <i class="fa fa-shopping-basket" aria-hidden="true"></i>
             <strong>Back to shopping</strong>
            </a>
        </div>  
        <!--Section: Block Content-->
        <section class="mb-5 body-detail-section">

            <div class="row">
                <div class="col-md-6 mb-4 mb-md-0">

                    <div id="mdb-lightbox-ui"></div>

                    <div class="mdb-lightbox">

                        <div class="row product-gallery mx-1">

                            <div class="col-12 mb-0">
                                <figure class="view overlay rounded z-depth-1 main-img">
                                    <a href="#"
                                       data-size="710x823">
                                        <img src="<s:property value="img"/>"
                                             class="img-fluid z-depth-1">
                                    </a>
                                </figure>
                            </div>
                            <div class="col-12">
                                <div class="row">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <form action ="addtocart" theme="simple">
                    <h5><s:property value="name"/></h5>
                    <p class="mb-2 text-muted text-uppercase small"><s:property value="category"/></p>
                    <p><span class="mr-1"><strong>$<s:property value="price"/></strong></span></p>
                    <hr>
                    <div class="table-responsive mb-2">
                        <table class="table table-sm table-borderless">
                            <tbody>
                                <tr>
                                    <td class="pl-0 pb-0 w-25">Quantity</td>
                                </tr>
                                <tr>
                                    <td class="pl-0">
                                        <div class="def-number-input number-input safari_only mb-0">
                                            <input class="quantity" min="0" name="amount" value="1" type="number">
                                        </div>
                                    </td>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <s:hidden name = "pid" value="%{pid}"/>
                    <button type="sumbit" Class="btn btn-light btn-md mr-1 mb-2">
                        <i class="fas fa-shopping-cart pr-2"></i> Add to cart
                    </button>
                    </form>
                </div>
            </div>
        </section>
        <%@ include file="Footer.jsp" %>
    </body>
</html>
