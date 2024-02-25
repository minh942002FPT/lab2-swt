<%-- 
    Document   : checkout
    Created on : Oct 25, 2023, 5:17:44 PM
    Author     : Tosaka
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h1 class="font-weight-semi-bold text-uppercase mb-3">Checkout</h1>
                    <div class="d-inline-flex">
                        <p class="m-0"><a href="">Home</a></p>
                        <p class="m-0 px-2">-</p>
                        <p class="m-0">Checkout</p>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->


            <!-- Checkout Start -->
            <<form action="checkoutcontroller" method="post">
                <div class="container-fluid pt-5">
                    <div class="row px-xl-5">
                        <div class="col-lg-8">
                            <div class="mb-4">
                                <h4 class="font-weight-semi-bold mb-4">Billing Address</h4>
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label>First Name</label>
                                        <input value="${addressAcc.getFirstName()}" class="form-control" type="text" name="FirstName" placeholder="em quân" required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Last Name</label>
                                        <input value="${addressAcc.getLastName()}" class="form-control" type="text" name="LastName" placeholder="vippro" required>
                                    </div>
                                    <!--                        <div class="col-md-6 form-group">
                                                                <label>E-mail</label>
                                                                <input class="form-control" type="text" placeholder="example@email.com">
                                                            </div>-->
                                    <div class="col-md-6 form-group">
                                        <label>Phone</label>
                                        <input value="${addressAcc.getPhone()}" class="form-control" type="text" name="Phone" placeholder="+84 123 456 789" required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label>Address</label>
                                        <input value="${addressAcc.getAddress()}" class="form-control" type="text" name="Address" placeholder="Giải phóng" required>
                                    </div>
                                    <!--                        <div class="col-md-6 form-group">
                                                                <label>Address Line 2</label>
                                                                <input class="form-control" type="text" placeholder="123 Street">
                                                            </div>-->
                                    <!--                        <div class="col-md-6 form-group">
                                                                <label>Country</label>
                                                                <select class="custom-select">
                                                                    <option selected>United States</option>
                                                                    <option>Afghanistan</option>
                                                                    <option>Albania</option>
                                                                    <option>Algeria</option>
                                                                </select>
                                                            </div>-->
                                    <div class="col-md-6 form-group">
                                        <label>City</label>
                                        <input value="${addressAcc.getCity()}" class="form-control" type="text" name="City" placeholder="Hà nội" required> 
                                    </div>
                                    <!--                        <div class="col-md-6 form-group">
                                                                <label>State</label>
                                                                <input class="form-control" type="text" placeholder="New York">
                                                            </div>-->
                                    <!--                        <div class="col-md-6 form-group">
                                                                <label>ZIP Code</label>
                                                                <input class="form-control" type="text" placeholder="123">
                                                            </div>-->
                                    <!--                        <div class="col-md-12 form-group">
                                                                <div class="custom-control custom-checkbox">
                                                                    <input type="checkbox" class="custom-control-input" id="newaccount">
                                                                    <label class="custom-control-label" for="newaccount">Create an account</label>
                                                                </div>
                                                            </div>-->
                                    <!--                        <div class="col-md-12 form-group">
                                                                <div class="custom-control custom-checkbox">
                                                                    <input type="checkbox" class="custom-control-input" id="shipto">
                                                                    <label class="custom-control-label" for="shipto"  data-toggle="collapse" data-target="#shipping-address">Ship to different address</label>
                                                                </div>
                                                            </div>-->
                                </div>
                            </div>
                            <!--                <div class="collapse mb-4" id="shipping-address">
                                                <h4 class="font-weight-semi-bold mb-4">Shipping Address</h4>
                                                <div class="row">
                                                    <div class="col-md-6 form-group">
                                                        <label>First Name</label>
                                                        <input class="form-control" type="text" placeholder="John">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>Last Name</label>
                                                        <input class="form-control" type="text" placeholder="Doe">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>E-mail</label>
                                                        <input class="form-control" type="text" placeholder="example@email.com">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>Mobile No</label>
                                                        <input class="form-control" type="text" placeholder="+123 456 789">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>Address Line 1</label>
                                                        <input class="form-control" type="text" placeholder="123 Street">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>Address Line 2</label>
                                                        <input class="form-control" type="text" placeholder="123 Street">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>Country</label>
                                                        <select class="custom-select">
                                                            <option selected>United States</option>
                                                            <option>Afghanistan</option>
                                                            <option>Albania</option>
                                                            <option>Algeria</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>City</label>
                                                        <input class="form-control" type="text" placeholder="New York">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>State</label>
                                                        <input class="form-control" type="text" placeholder="New York">
                                                    </div>
                                                    <div class="col-md-6 form-group">
                                                        <label>ZIP Code</label>
                                                        <input class="form-control" type="text" placeholder="123">
                                                    </div>
                                                </div>
                                            </div>-->
                        </div>
                        <div class="col-lg-4">
                            <div class="card border-secondary mb-5">
                                <div class="card-header bg-secondary border-0">
                                    <h4 class="font-weight-semi-bold m-0">Order Total</h4>
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
                                </div>
                            </div>
                            <div class="card border-secondary mb-5">
                                <div class="card-header bg-secondary border-0">
                                    <h4 class="font-weight-semi-bold m-0">Payment</h4>
                                </div>
                                
                                <div class="card-body">
                                    <div class="form-group">                                      
                                        <select class="form-control" name="PaymentMethod">   
                                            <c:forEach items="${listPaymentMethod}" var="item">
                                            <option value="${item.getMethod()}">${item.getMethodName()}</option>  
                                            </c:forEach> 
                                        </select>                                           
                                    </div>
                                </div>
                                
                                <div class="card-footer border-secondary bg-transparent">
                                    <button type="submit" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Place Order</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
            <!-- Checkout End -->


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
