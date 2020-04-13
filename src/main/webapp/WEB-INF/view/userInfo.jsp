<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 4/11/2020
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User info</title>
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
    <div class="div-table">
        <table>
            <c:if test="${sessionScope.role =='ADMIN'}">
                <tr>
                    <th>Parameter</th>
                    <th>Info</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td><c:out value="${sessionScope.id}"/></td>
                </tr>
                <tr>
                    <td>LOGIN</td>
                    <td><c:out value="${sessionScope.login}"/></td>
                </tr>
                <tr>
                    <td>PASSWORD</td>
                    <td><c:out value="${sessionScope.password}"/></td>
                </tr>
                <tr>
                    <td>NAME</td>
                    <td><c:out value="${sessionScope.name}"/></td>
                </tr>
                <tr>
                    <td>SURNAME</td>
                    <td><c:out value="${sessionScope.surname}"/></td>
                </tr>
                <tr>
                    <td>PHONE</td>
                    <td><c:out value="${sessionScope.phone}"/></td>
                </tr>
                <tr>
                    <td>ROLE</td>
                    <td><c:out value="${sessionScope.role}"/></td>
                </tr>

                <tr>
                    <td>UPDATE INFO</td>
                    <td>
                        <form method="post" name="about">
                            <button type="submit" class="bot1" name="command"
                                    value="redirect">Update
                            </button>
                            <input type="hidden" name="address"
                                   value="UPDATE_USER_PAGE"/>
                        </form>
                    </td>
                </tr>
            </c:if>

            <c:if test="${sessionScope.role =='CLIENT'}">
                <tr>
                    <th>Parameter</th>
                    <th>Info</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td><c:out value="${sessionScope.id}"/></td>
                </tr>
                <tr>
                    <td>LOGIN</td>
                    <td><c:out value="${sessionScope.login}"/></td>
                </tr>
                <tr>
                    <td>PASSWORD</td>
                    <td><c:out value="${sessionScope.password}"/></td>
                </tr>
                <tr>
                    <td>NAME</td>
                    <td><c:out value="${sessionScope.name}"/></td>
                </tr>
                <tr>
                    <td>SURNAME</td>
                    <td><c:out value="${sessionScope.surname}"/></td>
                </tr>
                <tr>
                    <td>DISCOUNT</td>
                    <td><c:out
                            value="${sessionScope.discount.discountSize}"/></td>
                </tr>
                <tr>
                    <td>CASH</td>
                    <td><c:out value="${sessionScope.cash}"/></td>
                </tr>
                <tr>
                    <td>PHONE</td>
                    <td><c:out value="${sessionScope.phone}"/></td>
                </tr>
                <tr>
                    <td>ROLE</td>
                    <td><c:out value="${sessionScope.role}"/></td>
                </tr>
                <tr>
                    <td>UPDATE INFO</td>
                    <td>
                        <form method="post" name="about">
                            <button type="submit" class="bot1" name="command"
                                    value="redirect">Update
                            </button>
                            <input type="hidden" name="address"
                                   value="UPDATE_USER_PAGE"/>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>DELETE ACCOUNT</td>
                    <td>
                        <form method="post">
                            <button class="bot1" type="submit" name="command"
                                    value="DELETE_CLIENT">
                                <input type="hidden" name="id"
                                       value="${sessionScope.id}"/>
                                Delete
                            </button>
                        </form>
                    </td>
                </tr>
            </c:if>
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
