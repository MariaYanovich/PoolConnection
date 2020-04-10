<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 17/03/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Travel agency</title>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0"/>
    <link rel="stylesheet" type="text/css"
          href="${root}/resources/css/mainPage.css">

</head>
<body>
<section class="hero">
    <header>
        <div class="wrapper">
            <a href="#" class="hamburger"></a>
            <nav>
                <c:if test="${role !='ADMIN'&& role!='CLIENT'}">

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
                <c:if test="${role =='ADMIN'|| role=='CLIENT'}">

                    <form name="sign_out" method="post">
                        <button type="submit" class="login_btn" name="command"
                                value="sign_out">Sign out
                        </button>
                    </form>
                </c:if>



                <form method="post" name="contact">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">Contact
                    </button>
                    <input type="hidden" name="address" value="CONTACT_PAGE"/>
                </form>

                <form method="post" name="about">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">About
                    </button>
                    <input type="hidden" name="address" value="ABOUT_PAGE"/>
                </form>

                <form method="post" name="search">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">Search
                    </button>
                    <input type="hidden" name="address" value="SEARCH_PAGE"/>
                </form>

                <form method="post" name="hotTours">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">Hot tours
                    </button>
                    <input type="hidden" name="address" value="HOME_PAGE"/>
                </form>

                <form method="post" name="home">
                    <button type="submit" class="just_btn" name="command"
                            value="redirect">Home
                    </button>
                    <input type="hidden" name="address" value="HOME_PAGE"/>
                </form>
            </nav>
        </div>
    </header><!--  end header section  -->
    <section class="caption">
        <h2 class="caption">Find Your Dream Tour</h2>
    </section>

    <c:if test="${role =='ADMIN'}">
        <h2>Hello, admin</h2>
    </c:if>
    <c:if test="${role =='CLIENT'}">
        <h2>Hello, client</h2>
    </c:if>

</section>
<!--  end hero section  -->


<footer>
    <div class="copyrights wrapper">
        Copyright © 2020
        All Rights Reserved.
    </div>
</footer><!--  end footer  -->
</body>
</html>