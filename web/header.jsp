<%-- 
    Document   : header
    Created on : Oct 26, 2023, 5:02:40 PM
    Author     : Tosaka
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Topbar Start -->
<div class="container-fluid">
    <div class="row bg-secondary py-2 px-xl-5">
        <div class="col-lg-6 d-none d-lg-block">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark" href="">FAQs</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Help</a>
                <span class="text-muted px-2">|</span>
                <a class="text-dark" href="">Support</a>
            </div>
        </div>
        <div class="col-lg-6 text-center text-lg-right">
            <div class="d-inline-flex align-items-center">
                <a class="text-dark px-2" href="https://www.facebook.com/quannt1127/">
                    <i class="fab fa-facebook-f"></i>
                </a>
            </div>
        </div>
    </div>
    <div class="row align-items-center py-3 px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a href="" class="text-decoration-none">
                <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
            </a>
        </div>
        <div class="col-lg-6 col-6 text-left">
            <form action="searchcontroller" method="post">
                <div class="input-group">
                    <input type="text" name="text" value="${textsearch}" class="form-control" placeholder="Search for products">
                    <div class="input-group-append">
                        <button class="input-group-text bg-transparent text-primary">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-lg-3 col-6 text-right">
 
            <a href="showcontroller" class="btn border">
                <i class="fas fa-shopping-cart text-primary"></i>
                <span class="badge">${requestScope.size}</span>
            </a>
        </div>
    </div>
</div>
<!-- Topbar End -->


<!-- Navbar Start -->
<div class="container-fluid">
    <div class="row border-top px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                <h6 class="m-0">${empty categoryname ? 'Danh mục sản phẩm' : categoryname}</h6>
                <i class="fa fa-angle-down text-dark"></i>
            </a>
            <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">

                <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                    <a href="shopcontroller" class="nav-item nav-link">Tất cả sản phẩm</a>
                    <c:forEach items="${listCategory}" var="item">
                        <a href="categorycontroller?mod=${item.getCategoryID()}" class="nav-item nav-link">${item.getCategoryName()}</a>
                    </c:forEach>
                </div>   

            </nav>
        </div>
        <div class="col-lg-9">
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                <a href="" class="text-decoration-none d-block d-lg-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0">
                        <a href="homecontroller" class="nav-item nav-link ${activePage == 'home' ? 'active' : ''}">Home</a>
                        <a href="shopcontroller" class="nav-item nav-link ${activePage == 'shop' ? 'active' : ''}">Shop</a>

                        <c:choose>
                            <c:when test="${shopdetail}">
                                <c:choose> 
                                    <c:when test="${activePage != 'detail'}">
                                        <a href="detailcontroller" class="nav-item nav-link ${activePage == 'detail' ? 'active' : ''}">Shop Detail</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="" class="nav-item nav-link active">Shop Detail</a>
                                    </c:otherwise>
                                </c:choose>                                    
                            </c:when>
                        </c:choose>                           

                        <a href="showcontroller" class="nav-item nav-link ${activePage == 'cart' ? 'active' : ''}">Shopping Cart</a>
                        <a href="checkoutcontroller" class="nav-item nav-link ${activePage == 'checkout' ? 'active' : ''}">Checkout</a>
                    </div>
                    <div class="navbar-nav ml-auto py-0">
                        <c:if test="${sessionScope.acc.getIsAdmin().equals('1')}">
                            <a href="managecontroller" class="nav-item nav-link ${activePage == 'manageproduct' ? 'active' : ''}">Statistics</a>
                            <a href="managecontroller" class="nav-item nav-link ${activePage == 'manageproduct' ? 'active' : ''}">Manage Users</a>                           
                            <a href="managecontroller" class="nav-item nav-link ${activePage == 'manageproduct' ? 'active' : ''}">Manage Product</a>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <a href="" class="nav-item nav-link">${sessionScope.acc.getUsername()}</a>
                            <a href="logoutcontroller" class="nav-item nav-link">Logout</a>
                        </c:if>
                        <c:if test="${sessionScope.acc == null}">
                            <a href="login.jsp" class="nav-item nav-link">Login</a>
                            <a href="register.jsp" class="nav-item nav-link">Register</a>
                        </c:if>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<!-- Navbar End -->
