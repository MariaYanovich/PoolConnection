<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 17/03/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Travel agency</title>
    <meta charset="utf-8">
    <meta name="author" content="pixelhint.com">
    <meta name="description"
          content="La casa free real state fully responsive html5/css3 home page website template"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0"/>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
<body>
<form action="controller" method="post">
    <section class="hero">
        <header>
            <div class="wrapper">
                <a href="#" class="hamburger"></a>
                <nav>
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/">Home</a>
                        </li>
                        <li><a href="#">Hot tours</a></li>
                        <li><a href="#">Search</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <button type="submit"
                            class="login_btn"
                            name="command" value="LOG_IN">Log in
                    </button>
                    <button type="submit"
                            class="login_btn"
                            name="command" value="SIGN_IN">Sign in
                    </button>
                </nav>
            </div>
        </header><!--  end header section  -->
        <section class="caption">
            <h2 class="caption">Find Your Dream Tour</h2>
        </section>
    </section><!--  end hero section  -->
</form>
<section class="listings">
    <div class="wrapper">
        <ul class="properties_list">
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_1.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$2500</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_2.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$1000</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_3.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$500</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_1.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$2500</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_2.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$1000</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_3.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$500</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_1.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$2500</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_2.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$1000</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/img/property_3.jpg"
                         alt="" title=""
                         class="property_img"/>
                </a>
                <span class="price">$500</span>
                <div class="property_details">
                    <h1>
                        <a href="#">Fuisque dictum tortor at purus libero</a>
                    </h1>
                    <h2>2 kitchens, 2 bed, 2 bath... <span
                            class="property_size">(288ftsq)</span></h2>
                </div>
            </li>
        </ul>
        <div class="more_listing">
            <a href="#" class="more_listing_btn">View More Listings</a>
        </div>
    </div>
</section>    <!--  end listing section  -->

<footer>
    <div class="copyrights wrapper">
        Copyright © 2020
        All Rights Reserved.
    </div>
</footer><!--  end footer  -->
</body>
</html>