<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/11/2020
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update user</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="ctg" uri="customTags" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">
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
</head>
<header>
    <c:import url="/WEB-INF/view/header.jsp"/>
</header>
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
                    <c:if test="${sessionScope.role =='CLIENT'}">Update client</c:if>
                    <c:if test="${sessionScope.role =='ADMIN'}">Update admin</c:if>
                 </span>

                <c:if test="${sessionScope.role =='ADMIN'}">

                    <div class="wrap-input100"
                         data-validate="Enter name">
                        <input class="input100" type="text" name="name"
                               required placeholder="New name">
                        <span class="focus-input100"
                              data-placeholder="&#xf207;"></span>
                    </div>

                    <div class="wrap-input100 "
                         data-validate="Enter surname">
                        <input class="input100" type="text" name="surname"
                               required placeholder="New surname">
                        <span class="focus-input100"
                              data-placeholder="&#xf207;"></span>
                    </div>

                    <div class="wrap-input100"
                         data-validate="Enter phone">
                        <input class="input100" type="text" name="phone"
                               placeholder="New phone">
                        <span class="focus-input100"
                              data-placeholder="&#xf207;"></span>
                    </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit"
                                name="command" value="UPDATE_ADMIN">OK
                        </button>
                    </div>
                </c:if>

                <c:if test="${sessionScope.role =='CLIENT'}">

                    <div class="wrap-input100"
                         data-validate="Enter new name">
                        <input class="input100" type="text" name="name"
                               required placeholder="New name">
                        <span class="focus-input100"
                              data-placeholder="&#xf207;"></span>
                    </div>

                    <div class="wrap-input100 "
                         data-validate="Enter new surname">
                        <input class="input100" type="text" name="surname"
                               required placeholder="New surname">
                        <span class="focus-input100"
                              data-placeholder="&#xf207;"></span>
                    </div>

                    <div class="wrap-input100"
                         data-validate="Enter new phone">
                        <input class="input100" type="text" name="phone"
                               placeholder="New phone">
                        <span class="focus-input100"
                              data-placeholder="&#xf095;"></span>
                    </div>

                    <div class="wrap-input100"
                         data-validate="Enter available cash">
                        <input class="input100" type="text" name="cash"
                               required placeholder="Available cash">
                        <span class="focus-input100"
                              data-placeholder="&#xe227;"></span>
                    </div>

                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit"
                                name="command" value="UPDATE_CLIENT">OK
                        </button>
                    </div>
                </c:if>
            </form>
        </div>
    </div>
</div>

<div id="dropDownSelect1"></div>
<footer>
    <div class="copyrights wrapper">
        <ctg:copyrightTag/>
    </div>
</footer>
</body>
</html>

