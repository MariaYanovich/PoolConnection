<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 3/23/2020
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1> Hello, Admin</h1>

<form method="post" name="sign_out" action="${pageContext.request.contextPath}/">
    <input type="hidden" name="to_page"
           value="HOME_PAGE"/>
    <input type="hidden" name="from_page"
           value="${pageType}"/>
    <button type="submit" class="login_btn" name="command"
            value="redirect">Sign out
    </button>
</form>
</body>
</html>
