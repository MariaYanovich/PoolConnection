<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/19/2020
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Service</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="ctg" uri="customTags" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
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
        <form class="login100-form validate-form" method="post">
            <div class="container-login100-form-btn">
                <button class="login100-form-btn"
                        name="address" value="ADD_TOUR_PAGE">
                    ADD NEW TOUR
                </button>
            </div>
        </form>
        <div class="container-login100"
             style="background-image: url('${pageContext.request.contextPath}/resources/img/bg-01.jpg');">
            <div class="wrap-login100">
                <form class="login100-form validate-form" method="post">
                    <span class="login100-form-title p-b-34 p-t-27">Input new city</span>
                    <div class="wrap-input100"
                         data-validate="Enter city">
                        <input class="input100" type="text" name="city"
                               required placeholder="City">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit"
                                name="command" value="add_city">
                            OK
                        </button>
                    </div>
                </form>
            </div>
            <div class="wrap-login100">
                <form class="login100-form validate-form" method="post">
                    <span class="login100-form-title p-b-34 p-t-27">Input new tour type</span>
                    <div class="wrap-input100"
                         data-validate="Enter type">
                        <input class="input100" type="text" name="tour_type"
                               required placeholder="Type">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit"
                                name="command" value="add_tour_type">
                            OK
                        </button>
                    </div>
                </form>
            </div>
            <div class="wrap-login100">
                <form class="login100-form validate-form" method="post">
                    <span class="login100-form-title p-b-34 p-t-27">Delete city</span>
                    <div class="wrap-input100">
                        <select name="city">
                            <option disabled="disabled">CITY</option>
                            <c:forEach items="${sessionScope.cities}"
                                       var="city">
                                <option value="${city.cityId}">${city.city}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit"
                                name="command" value="delete_city">
                            OK
                        </button>
                    </div>
                </form>
            </div>
            <div class="wrap-login100">
                <form class="login100-form validate-form" method="post">
                    <span class="login100-form-title p-b-34 p-t-27">Delete tour type</span>
                    <div class="wrap-input100">
                        <select name="tour_type">
                            <option disabled="disabled">TOUR TYPE</option>
                            <c:forEach items="${sessionScope.tour_types}"
                                       var="tourType">
                                <option value="${tourType.tourTypeId}">${tourType.type}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit"
                                name="command" value="delete_tour_type">
                            OK
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${root}/resources/js/chosen_v1.8.7/docsupport/jquery-3.2.1.min.js"
        type="text/javascript"></script>
<script src="${root}/resources/js/chosen_v1.8.7/chosen.jquery.js"
        type="text/javascript"></script>
<script src="${root}/resources/js/chosen_v1.8.7/docsupport/prism.js"
        type="text/javascript" charset="utf-8"></script>
<script src="${root}/resources/js/chosen_v1.8.7/docsupport/init.js"
        type="text/javascript" charset="utf-8"></script>
<script src="${root}/resources/js/global.js"></script>
<div id="dropDownSelect1"></div>
<footer>
    <div class="copyrights wrapper">
        <ctg:copyrightTag/>
    </div>
</footer>
</body>
</html>

