<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/13/2020
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <c:if test="${tour.isHot}">
        <button class="btn btn-info"
                aria-label="Hot"
                type="submit" name="command"
                value="un_hot_tour">
            <input type="hidden" name="tour_id"
                   value="${tour.tourId}"/>
            hot
        </button>
    </c:if>
    <c:if test="${!tour.isHot}">
        <button class="btn btn-info"
                aria-label="UnHot"
                type="submit" name="command"
                value="set_hot_tour">
            <input type="hidden" name="tour_id"
                   value="${tour.tourId}"/>
            not hot
        </button>
    </c:if>
</form>
</body>
</html>
