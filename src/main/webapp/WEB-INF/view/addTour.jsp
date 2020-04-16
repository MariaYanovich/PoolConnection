<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/16/2020
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sign Up</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->

    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/util.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css">
    <!--===============================================================================================-->
</head>
<body>
<div class="limiter">
    <div class="container-login100"
         style="background-image: url('${pageContext.request.contextPath}/resources/img/bg-01.jpg')">
        <div class="wrap-login100">
            <form class="login100-form validate-form" method="post">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

                <span class="login100-form-title p-b-34 p-t-27">
						Add tour
                </span>

                <div class="wrap-input100"
                     data-validate="Enter name">
                    <input class="input100" type="text" name="name"
                           required placeholder="Name">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>

                <div class="wrap-input100"
                     data-validate="Enter cost">
                    <input class="input100" type="password" name="cost"
                           required placeholder="Cost">
                    <span class="focus-input100"
                          data-placeholder="&#xf191;"></span>
                </div>

                <div class="wrap-input100"
                     data-validate="Enter departure date">
                    <input class="input100" type="date" name="departureDate"
                           required placeholder="Departure date">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>


                <div class="wrap-input100 "
                     data-validate="Enter days">
                    <input class="input100" type="text" name="days"
                           required placeholder="Days">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>

                <div class="wrap-input100"
                     data-validate="Enter places">
                    <input class="input100" type="text" name="places"
                           required placeholder="Places">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>

                <div class="wrap-input100"
                     data-validate="Enter tour type">
                    <input class="input100" type="text" name="tourType"
                           placeholder="Tour type">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>


                <div class="wrap-input100"
                     data-validate="Enter city">
                    <input class="input100" type="text" name="city"
                           placeholder="City">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>


                <div class="wrap-input100"
                     data-validate="Enter departure city">
                    <input class="input100" type="text" name="departureCity"
                           placeholder="Departure city">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit"
                            name="command" value="sign_up">OK
                    </button>
                </div>

                <div class="text-center p-t-20">
                    <a class="txt1"
                       href="${pageContext.request.contextPath}/">
                        Back to home </a>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="dropDownSelect1"></div>
</body>
</html>