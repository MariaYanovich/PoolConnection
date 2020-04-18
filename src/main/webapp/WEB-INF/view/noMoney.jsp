<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/18/2020
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>No money</title>
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
         style="background-image: url('${pageContext.request.contextPath}/resources/img/bg-01.jpg');">
        <div class="wrap-login100">

            <form class="login100-form validate-form" method="post">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
                    </span>

                <span class="login100-form-title p-b-34 p-t-27">Not enough money. Return to home page..</span>

            </form>
        </div>
    </div>
</div>

<div id="dropDownSelect1"></div>
</body>

</html>