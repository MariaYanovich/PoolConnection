<!DOCTYPE html>
<html lang="en">
<head>
    <title>About us</title>
    <meta charset="utf-8">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
          href=".${root}/resources/plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/about.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/about_responsive.css">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0"/>

    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">
</head>
<body>

<div class="super_container">
    <c:import url="/WEB-INF/view/header.jsp"/>
    <!-- Milestones -->

    <div class="milestones">
        <div class="container">
            <div class="row">

                <!-- Milestone -->
                <div class="col-lg-3 milestone_col">
                    <div class="milestone text-center">
                        <div class="milestone_icon"><img
                                src="${root}/resources/img/mountain.svg" alt="">
                        </div>
                        <div class="milestone_counter" data-end-value="17">0
                        </div>
                        <div class="milestone_text">Online Courses</div>
                    </div>
                </div>

                <!-- Milestone -->
                <div class="col-lg-3 milestone_col">
                    <div class="milestone text-center">
                        <div class="milestone_icon"><img
                                src="${root}/resources/img/island.svg" alt="">
                        </div>
                        <div class="milestone_counter" data-end-value="213">0
                        </div>
                        <div class="milestone_text">Students</div>
                    </div>
                </div>

                <!-- Milestone -->
                <div class="col-lg-3 milestone_col">
                    <div class="milestone text-center">
                        <div class="milestone_icon"><img
                                src="${root}/resources/img/camera.svg" alt="">
                        </div>
                        <div class="milestone_counter" data-end-value="11923">
                            0
                        </div>
                        <div class="milestone_text">Clients</div>
                    </div>
                </div>

                <!-- Milestone -->
                <div class="col-lg-3 milestone_col">
                    <div class="milestone text-center">
                        <div class="milestone_icon"><img
                                src="${root}/resources/img/boat.svg" alt="">
                        </div>
                        <div class="milestone_counter" data-end-value="15">0
                        </div>
                        <div class="milestone_text">Countries</div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- Why Choose Us -->

    <div class="row">
        <div class="col text-center">
            <div class="section_title"><h2>Why choose
                us?</h2></div>
        </div>
    </div>
    <div class="why">

        <div class="parallax_background parallax-window"
             data-parallax="scroll"
             data-image-src="${root}/resources/img/why.jpg"
             data-speed="0.8"></div>
        <div class="container">

            <div class="row why_row">

                <!-- Why item -->
                <div class="col-lg-4 why_col">
                    <div class="why_item">
                        <div class="why_image">
                            <img src="${root}/resources/img/why_1.jpg"
                                 alt="">
                            <div class="why_icon d-flex flex-column align-items-center justify-content-center">
                                <img src="${root}/resources/img/why_1.svg"
                                     alt="">
                            </div>
                        </div>
                        <div class="why_content text-center">
                            <div class="why_title">Fast Services
                            </div>
                            <div class="why_text">
                                <p>Pellentesque sit amet elementum
                                    ccumsan sit
                                    amet mattis eget, tristique at
                                    leo.</p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Why item -->
                <div class="col-lg-4 why_col">
                    <div class="why_item">
                        <div class="why_image">
                            <img src="${root}/resources/img/why_2.jpg"
                                 alt="">
                            <div class="why_icon d-flex flex-column align-items-center justify-content-center">
                                <img src="${root}/resources/img/why_2.svg"
                                     alt="">
                            </div>
                        </div>
                        <div class="why_content text-center">
                            <div class="why_title">Great Team</div>
                            <div class="why_text">
                                <p>Pellentesque sit amet elementum
                                    ccumsan sit
                                    amet mattis eget, tristique at
                                    leo.</p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Why item -->
                <div class="col-lg-4 why_col">
                    <div class="why_item">
                        <div class="why_image">
                            <img src="${root}/resources/img/why_3.jpg"
                                 alt="">
                            <div class="why_icon d-flex flex-column align-items-center justify-content-center">
                                <img src="${root}/resources/img/why_3.svg"
                                     alt="">
                            </div>
                        </div>
                        <div class="why_content text-center">
                            <div class="why_title">Best Deals</div>
                            <div class="why_text">
                                <p>Pellentesque sit amet elementum
                                    ccumsan sit
                                    amet mattis eget, tristique at
                                    leo.</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- Footer -->
    <footer>
        <div class="copyrights wrapper">
            Copyright © 2020
            All Rights Reserved.
        </div>
    </footer>
</div>

<script src="${root}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${root}/resources/css/bootstrap4/popper.js"></script>
<script src="${root}/resources/css/bootstrap4/bootstrap.min.js"></script>
<script src="${root}/resources/plugins/greensock/TweenMax.min.js"></script>
<script src="${root}/resources/plugins/greensock/TimelineMax.min.js"></script>
<script src="${root}/resources/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="${root}/resources/plugins/greensock/animation.gsap.min.js"></script>
<script src="${root}/resources/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="${root}/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="${root}/resources/plugins/easing/easing.js"></script>
<script src="${root}/resources/plugins/parallax-js-master/parallax.min.js"></script>
<script src="${root}/resources/js/about.js"></script>
</body>
</html>