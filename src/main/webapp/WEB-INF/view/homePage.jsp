<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 17/03/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Travel agency</title>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0"/>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/mainPage.css">

</head>
<body>
<section class="hero">

    <c:import url="/WEB-INF/view/header.jsp" />

    <section class="caption">
        <h2 class="caption">Find Your Dream Tour</h2>
    </section>

    <c:if test="${sessionScope.role =='ADMIN'}">
        <h2>Hello, admin</h2>
    </c:if>
    <c:if test="${sessionScope.role =='CLIENT'}">
        <h2>Hello, client</h2>
    </c:if>

</section>
<!--  end hero section  -->


<footer>
    <div class="copyrights wrapper">
        Copyright © 2020 All Rights Reserved.
    </div>
</footer><!--  end footer  -->
</body>
</html>