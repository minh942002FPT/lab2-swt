<%-- 
    Document   : editproduct
    Created on : Nov 1, 2023, 3:46:41 AM
    Author     : Tosaka
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Edit Detail</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Edit Detail</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Shop Detail Start -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <form action="editcontroller" method="post">
                    <div class="form-group">
                        <label for="productID">ProductID</label>
                        <input name="productID" value="${p.getProductID()}" type="text" class="form-control" id="productID" required>
                    </div>
                    <div class="form-group">
                        <label for="productName">Product Name</label>
                        <input name="productName" value="${p.getProductName()}" type="text" class="form-control" id="productName" required>
                    </div>
                    <div class="form-group">
                        <label for="productImage">Product Image</label>
                        <input name="productImage" value="${p.getProductImage()}" type="text" class="form-control" id="productImage" required>
                    </div>
                    <div class="form-group">
                        <label for="productPrice">Product Price</label>
                        <input name="productPrice" value="${p.getProductPrice()}" type="text" class="form-control" id="productPrice" required>
                    </div>
                    <div class="form-group">
                        <label for="Title">Title</label>
                        <input name="Title" value="${p.getTitle()}" type="text" class="form-control" id="Title" required>
                    </div>
                    <div class="form-group">
                        <label for="sizeID">SizeID</label>
                        <select name="sizeID" class="form-control" id="sizeID" required>
                        <c:forEach items="${listSize}" var="item">
                            <option value="${item.getSizeID()}">${item.getSizeName()}</option>
                        </c:forEach>                      
                    </select>
                    </div>
                    <div class="form-group">
                        <label for="colorID">ColorID</label>
                        <select name="colorID" class="form-control" id="colorID" required>

                        <c:forEach items="${listColor}" var="item">
                            <option value="${item.getColorID()}">${item.getColorName()}</option>
                        </c:forEach>

                    </select>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <input name="description" value="${p.getDescription()}" name="description" type="text" class="form-control" id="description" required>
                    </div>
                    <div class="form-group">
                        <label for="inStock">In Stock</label>
                        <input name="inStock" value="${p.getInStock()}" type="text" class="form-control" id="inStock" required>
                    </div>
                    <div class="form-group">
                        <label for="createDate">Create Date</label>
                        <input name="createDate" value="${p.getCreateDate()}" type="datetime-local" class="form-control" id="createDate" required>
                    </div>
                    <div class="form-group">
                        <label for="categoryID">CategoryID</label>
                        <select name="categoryID" class="form-control" id="categoryID" required>

                        <c:forEach items="${listCategory}" var="item">
                            <option value="${item.getCategoryID()}">${item.getCategoryName()}</option>
                        </c:forEach> 

                    </select>
                    </div>
                    <div class="modal-footer">
                        <a href="managecontroller" type="button" class="btn btn-secondary" data-dismiss="modal">Close</a>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Shop Detail End -->

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
