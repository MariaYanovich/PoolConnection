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
    <fmt:setLocale value="${locale}"/>
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">
</head>
<fmt:bundle basename="locale">
    <header>
        <div class="wrapper">
            <nav>
                <form method="post">
                    <c:if test="${sessionScope.role=='GUEST'}">
                    <button class="login_btn" name="command"
                            value="redirect"><fmt:message key="button.signIn"/>
                        <input type="hidden" name="address"
                               value="SIGN_IN_PAGE"/>
                    </button>
                </form>
                <form method="post">
                    <button class="login_btn" name="command"
                            value="redirect"><fmt:message key="button.signUp"/>
                        <input type="hidden" name="address"
                               value="SIGN_UP_PAGE"/>
                    </button>
                </form>
                </c:if>
                <c:if test="${sessionScope.role!='GUEST'}">
                    <form method="post">
                        <button type="submit" class="login_btn"
                                name="command" value="sign_out"><fmt:message
                                key="button.signOut"/>
                        </button>
                    </form>
                    <form method="post">
                        <button class="just_btn" name="command"
                                value="redirect"><fmt:message
                                key="button.userInfo"/>
                            <input type="hidden" name="address"
                                   value="USER_INFO_PAGE"/>
                        </button>
                    </form>
                </c:if>
                <c:if test="${sessionScope.role !='ADMIN'}">
                    <form method="post">
                        <button class="just_btn" name="command"
                                value="redirect"><fmt:message
                                key="button.contact"/>
                            <input type="hidden" name="address"
                                   value="CONTACT_PAGE"/>
                        </button>
                    </form>
                </c:if>
                <c:if test="${sessionScope.role !='GUEST'}">
                    <form method="post">
                        <button type="submit" class="just_btn" name="command"
                                value="GET_ORDERS"><fmt:message
                                key="button.orders"/>
                        </button>
                    </form>
                </c:if>
                <c:if test="${sessionScope.role =='ADMIN'}">
                    <form method="post">
                        <button type="submit" class="just_btn" name="command"
                                value="GET_USERS_LIST"><fmt:message
                                key="button.listOfUsers"/>
                        </button>
                    </form>
                </c:if>
                <c:if test="${sessionScope.role !='ADMIN'}">
                    <form method="post">
                        <button class="just_btn" name="command"
                                value="redirect"><fmt:message
                                key="button.about"/>
                            <input type="hidden" name="address"
                                   value="ABOUT_PAGE"/>
                        </button>
                    </form>
                </c:if>
                <c:if test="${sessionScope.role =='ADMIN'}">
                    <form method="post">
                        <button class="just_btn" name="command"
                                value="redirect"><fmt:message
                                key="button.createAdmin"/>
                        </button>
                        <input type="hidden" name="address"
                               value="CREATE_ADMIN_PAGE"/>
                    </form>
                </c:if>
                <c:if test="${sessionScope.role !='ADMIN'}">
                    <form method="post">
                        <button class="just_btn" name="command"
                                value="redirect"><fmt:message
                                key="button.search"/>
                        </button>
                        <input type="hidden" name="address"
                               value="SEARCH_PAGE"/>
                    </form>
                </c:if>
                <form method="post">
                    <button type="submit" class="just_btn" name="command"
                            value="GET_TOURS_LIST"><fmt:message
                            key="button.tours"/>
                    </button>
                </form>
                <c:if test="${sessionScope.role=='ADMIN'}">
                <form method="post">
                    <button class="just_btn" name="command"
                            value="redirect"><fmt:message key="button.service"/>
                        <input type="hidden" name="address"
                               value="SERVICE_PAGE"/>
                    </button>
                    </c:if>
                </form>
                <form method="post">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect"><fmt:message key="button.home"/>
                        <input type="hidden" name="address" value="HOME_PAGE"/>
                    </button>
                </form>
                <form method="post">
                    <button name="language" type="submit" class="just_btn"
                            value="en" style="padding: 12px 0 0 0;float: left;">
                        EN |
                    </button>
                </form>
                <form method="post">
                    <button name="language" type="submit" class="just_btn"
                            value="de"
                            style="padding: 12px 0 0 3px;float: left;">DE
                    </button>
                </form>
            </nav>
        </div>
    </header>
    </html>
</fmt:bundle>