<%-- 
    Document   : cart
    Created on : Oct 25, 2023, 12:58:23 PM
    Author     : Tosaka
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>EShopper</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <!-- Page Header Start -->
            <div class="container-fluid bg-secondary mb-5">
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
                    <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
                    <div class="d-inline-flex">
                        <p class="m-0"><a href="">Home</a></p>
                        <p class="m-0 px-2">-</p>
                        <p class="m-0">Shopping Cart</p>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->


            <!-- Cart Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <div class="col-lg-8 table-responsive mb-5">
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                                <tr>
                                    <th>Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                            <c:forEach items="${requestScope.cart.items}" var="item">
                                <tr>
                                    <td class="align-middle"><img src="${item.product.getProductImage()}" alt="" style="width: 50px;">${item.product.getProductName()}</td>
                                    <td class="align-middle"><fmt:formatNumber pattern="##.###" value="${item.getPrice()}"/></td>
                                    <td class="align-middle">
                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">
                                                <a class="btn btn-sm btn-primary btn-minus"  href="processcontroller?num=-1&productID=${item.product.getProductID()}">
                                                    <i class="fa fa-minus"></i>
                                                </a>
                                            </div>
                                            <p class="form-control form-control-sm bg-secondary text-center">${item.getQuantity()}</p>
                                            <a class="btn btn-sm btn-primary btn-plus" href="processcontroller?num=1&productID=${item.product.getProductID()}">
                                                <i class="fa fa-plus"></i>
                                            </a>
                                        </div>
                                        </div>
                                    </td>
                                    <td class="align-middle"><fmt:formatNumber pattern="##.###" value="${item.getPrice()*item.getQuantity()}"/></td>
                                    <td class="align-middle">
                                        <form action="processcontroller" method="post">
                                            <input type="hidden" name="productID" value="${item.product.getProductID()}">
                                            <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach> 

                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    <!--                <form class="mb-5" action="">
                                        <div class="input-group">
                                            <input type="text" class="form-control p-4" placeholder="Coupon Code">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary">Apply Coupon</button>
                                            </div>
                                        </div>
                                    </form>-->
                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                        </div>
                        <div class="card-body">
                            <h5 class="font-weight-medium mb-3">Products</h5>
                            <c:forEach items="${requestScope.cart.items}" var="item">
                                <div class="d-flex justify-content-between">
                                    <p>${item.product.getProductName()}</p>
                                    <p class="ml-auto">x${item.getQuantity()}&nbsp;&nbsp;&nbsp;</p>
                                    <p><fmt:formatNumber pattern="##.###" value="${item.getPrice()*item.getQuantity()}"/></p>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="card-footer border-secondary bg-transparent">

                            <div class="d-flex justify-content-between mt-2">
                                <h5 class="font-weight-bold">Total</h5>
                                <h5 class="font-weight-bold">${requestScope.cart.getTotalMoney()}</h5>
                            </div>
                            <form action="checkoutcontroller" method="get">
                                <button class="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->


        <jsp:include page="footer.jsp"></jsp:include>


        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>