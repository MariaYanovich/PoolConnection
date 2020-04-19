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
        <nav>

            <c:if test="${sessionScope.role=='GUEST'}">
                <form method="post" name="sign_in">
                    <button type="submit" class="login_btn" name="command"
                            value="redirect">
                        Sign in
                    </button>
                    <input type="hidden" name="address"
                           value="SIGN_IN_PAGE"/>
                </form>
                <form method="post" name="sign_up">
                    <button type="submit" class="login_btn" name="command"
                            value="redirect">
                        Sign up
                    </button>
                    <input type="hidden" name="address"
                           value="SIGN_UP_PAGE"/>
                </form>
            </c:if>

            <c:if test="${sessionScope.role!='GUEST'}">
                <form name="sign_out" method="post">
                    <button type="submit" class="login_btn"
                            name="command" value="sign_out">Sign out
                    </button>
                </form>
            </c:if>

            <c:if test="${sessionScope.role !='GUEST'}">
                <form method="post" name="about">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">User info
                    </button>
                    <input type="hidden" name="address" value="USER_INFO_PAGE"/>
                </form>
            </c:if>

            <c:if test="${sessionScope.role !='ADMIN'}">
                <form method="post" name="contact">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">Contact
                    </button>
                    <input type="hidden" name="address" value="CONTACT_PAGE"/>
                </form>
            </c:if>

            <c:if test="${sessionScope.role !='GUEST'}">
                <form method="post" name="tours_list">
                    <button type="submit" class="just_btn" name="command"
                            value="GET_ORDERS">Orders
                    </button>
                </form>
            </c:if>

            <c:if test="${sessionScope.role =='ADMIN'}">
                <form method="post" name="users_list">
                    <button type="submit" class="just_btn" name="command"
                            value="GET_USERS_LIST">List of users
                    </button>
                </form>
            </c:if>

            <c:if test="${sessionScope.role !='ADMIN'}">
                <form method="post" name="about">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">About
                    </button>
                    <input type="hidden" name="address" value="ABOUT_PAGE"/>
                </form>
            </c:if>

            <c:if test="${sessionScope.role =='ADMIN'}">
                <form method="post" name="about">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">Create admin
                    </button>
                    <input type="hidden" name="address"
                           value="CREATE_ADMIN_PAGE"/>
                </form>
            </c:if>

            <c:if test="${sessionScope.role !='ADMIN'}">
                <form method="post" name="search">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">Search
                    </button>
                    <input type="hidden" name="address" value="SEARCH_PAGE"/>
                </form>
            </c:if>

            <form method="post" name="tours_list">
                <button type="submit" class="just_btn" name="command"
                        value="GET_TOURS_LIST">Tours
                </button>
            </form>

            <c:if test="${sessionScope.role=='ADMIN'}">
                <form method="post">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">
                        Add tour
                    </button>
                    <input type="hidden" name="address"
                           value="ADD_TOUR_PAGE"/>
                </form>
                <form method="post">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">
                        Service
                    </button>
                    <input type="hidden" name="address"
                           value="SERVICE_PAGE"/>
                </form>
            </c:if>
            <form method="post" name="home">
                <button type="submit" class="just_btn" name="command"
                        value="redirect">Home
                </button>
                <input type="hidden" name="address" value="HOME_PAGE"/>
            </form>
        </nav>
    </div>
</header>
</html>
