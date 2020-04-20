<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/10/2020
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0"/>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">
</head>
<header>
    <div class="wrapper">
        <a href="#" class="hamburger"></a>
        <form method="post">
            <nav>
                <c:if test="${sessionScope.role=='GUEST'}">
                    <button class="login_btn" name="address"
                            value="SIGN_IN_PAGE">Sign in
                    </button>
                    <button class="login_btn" name="address"
                            value="SIGN_UP_PAGE">Sign up
                    </button>
                </c:if>
                <c:if test="${sessionScope.role!='GUEST'}">
                    <button type="submit" class="login_btn"
                            name="command" value="sign_out">Sign out
                    </button>
                    <button class="just_btn" name="address"
                            value="USER_INFO_PAGE">User info
                    </button>
                </c:if>
                <c:if test="${sessionScope.role !='ADMIN'}">
                    <button class="just_btn" name="address"
                            value="CONTACT_PAGE">Contact
                    </button>
                </c:if>
                <c:if test="${sessionScope.role !='GUEST'}">
                    <button type="submit" class="just_btn" name="command"
                            value="GET_ORDERS">Orders
                    </button>
                </c:if>
                <c:if test="${sessionScope.role =='ADMIN'}">
                    <form method="post">
                        <button type="submit" class="just_btn" name="command"
                                value="GET_USERS_LIST">List of users
                        </button>
                    </form>
                </c:if>
                <c:if test="${sessionScope.role !='ADMIN'}">
                    <button class="just_btn" name="address"
                            value="ABOUT_PAGE">About
                    </button>
                </c:if>
                <c:if test="${sessionScope.role =='ADMIN'}">
                    <button class="just_btn" name="address"
                            value="CREATE_ADMIN_PAGE">Create admin
                    </button>
                </c:if>
                <c:if test="${sessionScope.role !='ADMIN'}">
                    <button class="just_btn" name="address"
                            value="SEARCH_PAGE">Search
                    </button>
                </c:if>
                <button type="submit" class="just_btn" name="command"
                        value="GET_TOURS_LIST">Tours
                </button>
                <c:if test="${sessionScope.role=='ADMIN'}">
                    <button class="just_btn" name="address"
                            value="SERVICE_PAGE">Service
                    </button>
                </c:if>
                <button name="language" type="submit" class="just_btn"
                        value="ru">DE
                </button>
                <button name="language" type="submit" class="just_btn"
                        value="en">EN
                </button>
            </nav>
        </form>
    </div>
</header>
</html>
