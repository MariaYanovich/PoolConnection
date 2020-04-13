<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 3/23/2020
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sign In</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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
         style="background-image: url('${pageContext.request.contextPath}/resources/img/bg-01.jpg');">
        <div class="wrap-login100">

            <form class="login100-form validate-form" method="post">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
                    </span>

                <span class="login100-form-title p-b-34 p-t-27">Sign in</span>

                <div class="wrap-input100"
                     data-validate="Enter login">
                    <input class="input100" type="text" name="login"
                           required placeholder="Login">
                    <span class="focus-input100"
                          data-placeholder="&#xf207;"></span>
                </div>

                <div class="wrap-input100"
                     data-validate="Enter password">
                    <input class="input100" type="password" name="password"
                           required placeholder="Password">
                    <span class="focus-input100"
                          data-placeholder="&#xf191;"></span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit"
                            name="command" value="sign_in">OK
                    </button>
                </div>
                <div class="text-center p-t-30">
                    <a class="txt1" href="${pageContext.request.contextPath}/">
                        Back to home </a>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="dropDownSelect1"></div>
</body>
</html>


