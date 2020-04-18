<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/18/2020
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>All orders</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="ctg" uri="customTags" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/table.css">
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">

</head>

<header>
    <c:import url="/WEB-INF/view/header.jsp"/>
</header>
<body>
<section class="hero">

<jsp:useBean id="orders" class="java.util.ArrayList" scope="request"/>
<div class="div-table">
    <table>
        <tr>
            <th>ORDER ID</th>
            <th>USER ID</th>
            <th>USER LOGIN</th>
            <th>TOUR ID</th>
            <th>TOUR NAME</th>
            <th>TOUR NUMBER</th>
            <th>PRICE</th>
            <c:if test="${sessionScope.role=='CLIENT'}">
                <th>CANCEL</th>
            </c:if>

        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td><c:out value="${order.orderId}"/></td>
                <td><c:out value="${order.user.id}"/></td>
                <td><c:out value="${order.user.login}"/></td>
                <td><c:out value="${order.tour.tourId}"/></td>
                <td><c:out value="${order.tour.name}"/></td>
                <td><c:out value="${order.number}"/></td>
                <td><c:out value="${order.price}"/></td>
                <c:if test="${sessionScope.role=='CLIENT'}">
                    <td>
                        <form method="post">
                            <button class="bot1" type="submit" name="command"
                                    value="cancel_buying_tour">
                                <input type="hidden" name="order_id"
                                       value="${order.orderId}"/>
                                cancel
                            </button>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</section>
</body>
<footer>
    <div class="copyrights wrapper">
        <ctg:copyrightTag/>
    </div>
</footer>
</html>