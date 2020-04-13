<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search</title>
    <meta charset="utf-8">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="ctg" uri="customTags" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Travello template project">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/bootstrap4/bootstrap.min.css">
    <link href="${root}/resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/news.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/news_responsive.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">
</head>
<body>

<div class="super_container">

    <c:import url="/WEB-INF/view/header.jsp"/>

    <!-- Home -->

    <div class="home">
        <div class="background_image"
             style="background-image:url(${root}/resources/img/news.jpg)"></div>
    </div>

    <!-- Search -->

    <div class="home_search">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="home_search_container">
                        <div class="home_search_title">Search for your trip
                        </div>
                        <div class="home_search_content">
                            <form action="#" class="home_search_form"
                                  id="home_search_form">
                                <div class="d-flex flex-lg-row flex-column align-items-start justify-content-lg-between justify-content-start">
                                    <input type="text"
                                           class="search_input search_input_1"
                                           placeholder="City"
                                           required="required">
                                    <input type="text"
                                           class="search_input search_input_2"
                                           placeholder="Departure"
                                           required="required">
                                    <input type="text"
                                           class="search_input search_input_3"
                                           placeholder="Arrival"
                                           required="required">
                                    <input type="text"
                                           class="search_input search_input_4"
                                           placeholder="Budget"
                                           required="required">
                                    <button class="home_search_button">search
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="copyrights wrapper">
            <ctg:copyrightTag/>
        </div>
    </footer>
</div>

<script src="${root}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${root}/resources/css/bootstrap4/popper.js"></script>
<script src="${root}/resources/css/bootstrap4/bootstrap.min.js"></script>
<script src="${root}/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="${root}/resources/plugins/easing/easing.js"></script>
<script src="${root}/resources/plugins/parallax-js-master/parallax.min.js"></script>
<script src="${root}/resources/js/news.js"></script>
</body>
</html>