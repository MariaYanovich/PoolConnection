<%--
  Created by IntelliJ IDEA.
  User: yanov
  Date: 16/03/2020
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-center">
    <p>Something went wrong...
        Return to the main page, please :)</p>
    <p>Status: ${pageContext.errorData.statusCode}</p>
    <p>Request URI: ${pageContext.errorData.requestURI}</p>
</div>
<div class="w3-container w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large w3-hover-pale-yellow"
            onclick="location.href='/TravelAgency'">
        Back to
        home
    </button>
</div>

</body>
</html>