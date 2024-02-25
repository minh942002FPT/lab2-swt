<%-- 
    Document   : manageproduct
    Created on : Oct 30, 2023, 1:23:51 AM
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
                    <h1 class="font-weight-semi-bold text-uppercase mb-3">Manage product</h1>
                    <div class="d-inline-flex">
                        <p class="m-0"><a href="">Home</a></p>
                        <p class="m-0 px-2">-</p>
                        <p class="m-0">Manage product</p>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->

            <!-- Product Start -->
            <div class="container-fluid pt-0 pb-4">
                <!-- Manage Product Start -->
                <div class="col-12 pb-1 d-flex align-items-center justify-content-end mb-4">
                    <!-- Search Start -->
                    <form action="">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search by name">
                            <div class="input-group-append">
                                <button class="input-group-text bg-transparent text-primary">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <!-- Search End -->
                    <div class="card-footer border-secondary bg-transparent ml-auto">
                        <button type="button" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3" data-toggle="modal" data-target="#addProductModal">Add Product</button>
                    </div>
                </div>

                <!-- Manage Product End -->
                <div class="col-lg-12 table-responsive mb-0">
                    <table class="table table-bordered text-center mb-0">
                        <thead class="bg-secondary text-dark">
                            <tr>
                                <th>ID</th>
                                <th>Products</th>
                                <th>Size</th>
                                <th>Color</th>
                                <th>Price</th>
                                <th>Category</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody class="align-middle">
                        <c:forEach items="${listProduct}" var="item">
                            <tr>
                                <td>${item.getProductID()}</td>
                                <td class="align-middle"><img src="${item.getProductImage()}" alt="" style="width: 50px;">${item.getProductName()}</td>
                                <td class="align-middle">${item.getSizeID()}</td>
                                <td class="align-middle">${item.getColorID()}</td>
                                <td class="align-middle">${item.getProductPrice()}</td>
                                <td class="align-middle">${item.getCategoryID()}</td>
                                <td class="align-middle">
                                    <button class="btn btn-sm btn-primary edit-product" data-toggle="modal" data-target="#editProductModal" onclick="editProduct(${item.getProductID()})"><i class="fa fa-edit"></i></button>                                 
                                    <a href="deletecontroller?pid=${item.getProductID()}" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <!-- Product End -->

        <!-- Paging start -->
        <div class="col-12 pb-1">
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center mb-3">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>

                    <c:forEach begin="1" end="${endPage}" var="item">
                        <li class="page-item active">                               
                            <a class="page-link" href="managecontroller?page=${item}">${item}</a>                               
                        </li>
                    </c:forEach>

                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- Paging End -->

        <!-- Add Product Start -->
        <div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="addcontroller" method="post" id="addProductForm">
                            <div class="form-group">
                                <label for="productName">Product Name</label>
                                <input name="productName" type="text" class="form-control" id="productName" required>
                            </div>
                            <div class="form-group">
                                <label for="productImage">Product Image</label>
                                <input name="productImage" type="text" class="form-control" id="productImage" required>
                            </div>
                            <div class="form-group">
                                <label for="productPrice">Product Price</label>
                                <input name="productPrice" type="text" class="form-control" id="productPrice" required>
                            </div>
                            <div class="form-group">
                                <label for="Title">Title</label>
                                <input name="Title" type="text" class="form-control" id="Title" required>
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
                                <input name="description" type="text" class="form-control" id="inStock" required>
                            </div>
                            <div class="form-group">
                                <label for="inStock">In Stock</label>
                                <input name="inStock" type="text" class="form-control" id="inStock" required>
                            </div>
                            <div class="form-group">
                                <label for="createDate">Create Date</label>
                                <input name="createDate" type="datetime-local" class="form-control" id="createDate" required>
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
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!-- Add Product End -->


        <jsp:include page="footer.jsp"></jsp:include>

        <script>
            document.getElementById('addProductForm').addEventListener('submit', function (event) {
                var productName = document.getElementById('productName').value;
                var productImage = document.getElementById('productImage').value;
                var productPrice = document.getElementById('productPrice').value;
                var title = document.getElementById('Title').value;
                var sizeid = document.getElementById('sizeID').value;
                var colorid = document.getElementById('colorID').value;
                var description = document.getElementById('description').value;
                var instock = document.getElementById('inStock').value;
                var createdate = document.getElementById('createDate').value;
                var categoryid = document.getElementById('categoryID').value;
                // Use productName and productPrice to add the product (you can customize this part)
                // For example, you can send an HTTP request to your backend to add the product
                console.log('Product Name:', productName);
                console.log('Product Image:', productImage);
                console.log('Product Price:', productPrice);
                console.log('Title:', title);
                console.log('SizeID:', sizeid);
                console.log('ColorID:', colorid);
                console.log('Description', description);
                console.log('In Stock:', instock);
                console.log('Create Date:', createdate);
                console.log('CategoryID:', categoryid);
                $('#addProductModal').modal('hide'); // Close the modal after submission
            });
        </script>   

        <script>
            function editProduct(productID) {
                window.location.href = "editcontroller?productID=" + productID;
            }
        </script>






        <!-- Add product end-->



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