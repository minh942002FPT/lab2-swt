<%-- 
    Document   : login.jsp
    Created on : Oct 28, 2023, 9:52:07 PM
    Author     : Tosaka
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <title>Login</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
    </head>

    <body>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp" class="img-fluid" alt="Sample image">
                    </div>
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <form id="loginForm" action ="logincontroller" method="post">
                            <div class="divider d-flex align-items-center my-4">
                                <p class="text-center fw-bold mx-3 mb-0 display-4"><b>Login</b></p>
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="username" name="username" class="form-control form-control-lg" placeholder="Username" />
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-3">
                                <input type="password" name="password" class="form-control form-control-lg" placeholder="Password" />
                            </div>
                            <p class="form-outline mb-3" style="color: red">${err}</p>
                            <!-- Checkbox and Register -->
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <div class="form-check">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                                    <label class="form-check-label" for="form2Example3">Remember me</label>
                                </div>
                                <p class="small fw-bold mb-0">Don't have an account? <a href="#!" class="link-danger">Register</a></p>
                            </div>


                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button type="submit" class="btn btn-primary btn-lg" style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                            </div>

                        </form>
                        <form id="registerForm" action ="signupcontroller" method="post" style="display:none;">
                            <form>
                                <div class="divider d-flex align-items-center my-4">
                                    <p class="text-center fw-bold mx-3 mb-0 display-4"><b>Register</b></p>
                                </div>

                                <!-- Email input -->
                                <div class="form-outline mb-4">
                                    <input type="username" name="username" class="form-control form-control-lg" placeholder="Username" />
                                </div>

                                <!-- Password input -->
                                <div class="form-outline mb-3">
                                    <input type="password" name="password" class="form-control form-control-lg" placeholder="Password" />
                                </div>

                                <div class="form-outline mb-3">
                                    <input type="password" name="repassword" id="form3Example4" class="form-control form-control-lg" placeholder="Confirm password" />
                                </div>
                                <p class="form-outline mb-3" style="color: red">${err2}</p>
                                <p class="form-outline mb-3" style="color: red">${err3}</p>
                                <!-- Checkbox and Register -->
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <div class="form-check">
                                        <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" required/>
                                        <label class="form-check-label" for="form2Example3">I agree with Terms and Conditions</label>
                                    </div>
                                    <p class="small fw-bold mb-0">Already have an account? <a href="#!" class="link-danger">Sign in</a></p>
                                </div>


                                <div class="text-center text-lg-start mt-4 pt-2">
                                    <button type="submit" class="btn btn-primary btn-lg" style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
            <div class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
                <!-- Copyright -->
                <div class="text-white mb-3 mb-md-0">
                    Copyright © 2023. All rights reserved.
                </div>
                <!-- Copyright -->

            </div>
        </section>

        <script>
            // Function to toggle between login and register forms
            function toggleForms() {
                $('#loginForm').toggle();
                $('#registerForm').toggle();
            }

            // Add an event listener to the "Register" link
            $('.link-danger').on('click', function (e) {
                e.preventDefault(); // Prevent the default link behavior
                toggleForms(); // Toggle between forms
            });

        </script>

    </body>

</html>
