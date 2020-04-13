<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/13/2020
  Time: 3:22 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hot tours</title>
    <meta charset="utf-8">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
          rel="stylesheet">
    <link rel="stylesheet"
          href="${root}/resources/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${root}/resources/css/animate.css">
    <link rel="stylesheet" href="${root}/resources/css/owl.carousel.min.css">
    <link rel="stylesheet"
          href="${root}/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${root}/resources/css/magnific-popup.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/table.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">
    <link rel="stylesheet" href="${root}/resources/css/aos.css">
    <link rel="stylesheet" href="${root}/resources/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${root}/resources/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${root}/resources/css/jquery.timepicker.css">
    <link rel="stylesheet" href="${root}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${root}/resources/css/icomoon.css">
    <link rel="stylesheet" href="${root}/resources/css/style.css">

</head>
<body>
<header>
    <c:import url="/WEB-INF/view/header.jsp"/>
</header>

<section class="ftco-section">
    <div class="container">
        <div class="row">
            <jsp:useBean id="tours" class="java.util.ArrayList"
                         scope="request"/>
            <c:forEach items="${tours}" var="tour">
                <div class="col-md-6 col-lg-4 ftco-animate">
                    <div class="project">
                        <div class="img">
                            <img src="data:image/jpg;base64,${tour.imageString}"
                                 class="img-fluid" alt="Colorlib Template">
                        </div>
                        <div class="text">
                            <h4 class="price"><c:out
                                    value="${tour.cost}$"/></h4>
                            <span><c:out value="${tour.days}"/> days</span>
                            <h3><c:out value="${tour.name} in ${tour.city.city}"/>
                            </h3>
                            <div class="star d-flex clearfix">
                                <div class="mr-auto float-left">
                                    <span class="rate">${tour.departureDate}</span>
                                </div>
                            </div>
                            <div class="star d-flex clearfix">
                                <div class="mr-auto float-left">
                                    <span class="ion-ios-star"><c:out
                                            value="${tour.tourType.type}"/></span>
                                </div>
                            </div>
                            <div class="star d-flex clearfix">
                                <div class="mr-auto float-left">
                                    <span class="ion-ios-star"><c:out
                                            value="${tour.transport.type}"/></span>
                                </div>
                            </div>
                            <div class="star d-flex clearfix">
                                <div class="mr-auto float-left">
                                    <span class="ion-ios-star"><c:out
                                            value="from ${tour.departureCity.city}"/></span>
                                </div>
                            </div>
                        </div>
                        <a href="data:image/jpg;base64,${tour.imageString}"
                           class="icon image-popup d-flex justify-content-center align-items-center">
                            <span class="icon-expand"></span>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<footer>
    <div class="copyrights wrapper">
        Copyright © 2020 All Rights Reserved.
    </div>
</footer>

<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none"
                stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4"
                stroke-miterlimit="10" stroke="#F96D00"/>
    </svg>
</div>


<script src="${root}/resources/js/jquery.min.js"></script>
<script src="${root}/resources/js/jquery-migrate-3.0.1.min.js"></script>
<script src="${root}/resources/js/popper.min.js"></script>
<script src="${root}/resources/js/bootstrap.min.js"></script>
<script src="${root}./resources/js/jquery.easing.1.3.js"></script>
<script src="${root}/resources/js/jquery.waypoints.min.js"></script>
<script src="${root}/resources/js/jquery.stellar.min.js"></script>
<script src="${root}/resources/js/owl.carousel.min.js"></script>
<script src="${root}/resources/js/jquery.magnific-popup.min.js"></script>
<script src="${root}/resources/js/aos.js"></script>
<script src="${root}/resources/js/jquery.animateNumber.min.js"></script>
<script src="${root}/resources/js/bootstrap-datepicker.js"></script>
<script src="${root}/resources/js/scrollax.min.js"></script>
<script src="${root}/resources/js/main.js"></script>

</body>
</html>
