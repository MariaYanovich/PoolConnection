<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/17/2020
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/16/2020
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update tour</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="ctg" uri="customTags" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet"
          href="${root}/resources/js/chosen_v1.8.7/docsupport/style.css">
    <link rel="stylesheet"
          href="${root}/resources/js/chosen_v1.8.7/docsupport/prism.css">
    <link rel="stylesheet" href="${root}/resources/js/chosen_v1.8.7/chosen.css">

    <meta http-equiv="Content-Security-Policy"
          content="default-src &apos;self&apos;; script-src &apos;self&apos; https://ajax.googleapis.com; style-src &apos;self&apos;; img-src &apos;self&apos; data:">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Title Page-->
    <title>Add tour</title>

    <!-- Icons font CSS-->
    <link href="${root}/resources/vendor/mdi-font/css/material-design-iconic-font.min.css"
          rel="stylesheet" media="all">
    <link href="${root}/resources/vendor/font-awesome-4.7/css/font-awesome.min.css"
          rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
          rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="${root}/resources/vendor/select2/select2.min.css"
          rel="stylesheet" media="all">
    <link href="${root}/resources/vendor/datepicker/daterangepicker.css"
          rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${root}/resources/css/addTour.css" rel="stylesheet" media="all">
</head>
<header>
    <c:import url="/WEB-INF/view/header.jsp"/>
</header>
<body>

<div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
    <div class="wrapper wrapper--w680">
        <div class="card card-1">
            <div class="card-heading"></div>
            <div class="card-body">
                <h2 class="title">Update tour info:</h2>
                <form method="post" name="update_tour"
                      enctype="multipart/form-data">

                    <div class="input-group">
                        <h4>Previous cost: ${sessionScope.tour.cost}</h4>
                        <input class="input--style-1" type="text" required
                               placeholder="NEW COST" name="cost">
                    </div>
                    <div class="input-group">
                        <h4>Previous days: ${sessionScope.tour.days}</h4>
                        <input class="input--style-1" type="text" required
                               placeholder="NEW DAYS" name="days">
                    </div>

                    <div class="input-group">
                        <h4>Previous places: ${sessionScope.tour.places}</h4>
                        <input class="input--style-1" type="text" required
                               placeholder="NEW PLACES" name="places">
                    </div>
                    <div class="row row-space">
                        <div class="col-2">
                            <div class="input-group">
                                <h4>Previous tour
                                    type: ${sessionScope.tour.tourType.type}</h4>
                                <div class="rs-select2 js-select-simple select--no-search">
                                    <select name="tour_type">
                                        <option disabled="disabled">NEW TOUR
                                            TYPE
                                        </option>
                                        <c:forEach
                                                items="${sessionScope.tour_types}"
                                                var="tourType">
                                            <option value="${tourType.tourTypeId}">${tourType.type}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="select-dropdown"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="input-group">
                                <h4>Previous
                                    transport: ${sessionScope.tour.transport.type}</h4>
                                <div class="rs-select2 js-select-simple select--no-search">
                                    <select name="tour_transport">
                                        <option disabled="disabled">NEW
                                            TRANSPORT
                                        </option>
                                        <c:forEach
                                                items="${sessionScope.transports}"
                                                var="transport">
                                            <option value="${transport.transportId}">${transport.type}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="select-dropdown"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row row-space">
                        <div class="col-2">
                            <div class="input-group">
                                <h4>Previous to
                                    city: ${sessionScope.tour.city.city}</h4>
                                <div class="rs-select2 js-select-simple select--no-search">
                                    <select name="to_city">
                                        <option disabled="disabled">NEW TO CITY
                                        </option>
                                        <c:forEach
                                                items="${sessionScope.cities}"
                                                var="city">
                                            <option value="${city.cityId}">${city.city}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="select-dropdown"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="input-group">
                                <h4>Previous departure
                                    city: ${sessionScope.tour.departureCity.city}</h4>
                                <div class="rs-select2 js-select-simple select--no-search">
                                    <select name="departure_city">
                                        <option disabled="disabled">NEW
                                            DEPARTURE
                                            CITY
                                        </option>
                                        <c:forEach
                                                items="${sessionScope.cities}"
                                                var="city">
                                            <option value="${city.cityId}">${city.city}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="select-dropdown"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="input-group">
                        <h4>Previous
                            date: ${sessionScope.tour.departureDate}</h4>
                        <input class="input--style-1"
                               type="date" required
                               placeholder="NEW DEPARTURE DATE"
                               name="departure_date">
                    </div>

                    <button type="submit" class="btn btn-info"
                            aria-label="Update"
                            name="command" value="update_tour">Submit
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Jquery JS-->
<script src="${root}/resources/vendor/jquery/jquery.min.js"></script>

<!-- Vendor JS-->
<script src="${root}/resources/vendor/select2/select2.min.js"></script>
<script src="${root}/resources/vendor/datepicker/moment.min.js"></script>
<script src="${root}/resources/vendor/datepicker/daterangepicker.js"></script>
<script src="${root}/resources/js/chosen_v1.8.7/docsupport/jquery-3.2.1.min.js"
        type="text/javascript"></script>
<script src="${root}/resources/js/chosen_v1.8.7/chosen.jquery.js"
        type="text/javascript"></script>
<script src="${root}/resources/js/chosen_v1.8.7/docsupport/prism.js"
        type="text/javascript" charset="utf-8"></script>
<script src="${root}/resources/js/chosen_v1.8.7/docsupport/init.js"
        type="text/javascript" charset="utf-8"></script>
<!-- Main JS-->
<script src="${root}/resources/js/global.js"></script>


<div id="dropDownSelect1"></div>
</body>
<footer>
    <div class="copyrights wrapper">
        <ctg:copyrightTag/>
    </div>
</footer>
</html>


