<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/10/2020
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>All users</title>
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
<section class="hero">
    <jsp:useBean id="users" class="java.util.ArrayList" scope="request"/>
    <div class="div-table">
        <table>
            <tr>
                <th>ID</th>
                <th>LOGIN</th>
                <th>PASSWORD</th>
                <th>NAME</th>
                <th>SURNAME</th>
                <th>DISCOUNT</th>
                <th>CASH</th>
                <th>PHONE</th>
                <th>ROLE</th>
                <th>VIEW ORDERS</th>
                <th>BLOCK/UNBLOCK</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userId}"/></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.passwordStr}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.surname}"/></td>
                    <td><c:out value="${user.discount.discountSize}"/></td>
                    <td><c:out value="${user.cash}"/></td>
                    <td><c:out value="${user.phone}"/></td>
                    <td><c:out value="${user.role}"/></td>
                    <td>
                        <form method="post">
                            <button class="bot1" type="submit"
                                    name="command"
                                    value="get_orders_by_user_id">
                                <input type="hidden" name="user_id"
                                       value="${user.userId}"/>
                                view
                            </button>
                        </form>
                    </td>
                    <td>
                        <form method="post">
                            <c:if test="${user.role =='BLOCKED'}">
                                <button class="bot1" type="submit"
                                        name="command"
                                        value="unblock_client">
                                    <input type="hidden" name="user_id"
                                           value="${user.userId}"/>
                                    unblock
                                </button>
                            </c:if>

                            <c:if test="${user.role =='CLIENT'}">
                                <button class="bot1" type="submit"
                                        name="command"
                                        value="block_client">
                                    <input type="hidden" name="user_id"
                                           value="${user.userId}"/>
                                    block
                                </button>
                            </c:if>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</html>
