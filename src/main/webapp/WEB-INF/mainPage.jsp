<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Slow News</title>
    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link href='http://fonts.googleapis.com/css?family=Changa+One|Open+Sans:400italic,700italic,400,700,800'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/responsive.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<header>
    <a href="newsList" class="logo">
        <h1>Slow News</h1>
    </a>
    <nav>
        <ul>
            <li class="header-link" class="selected"><a href="newsList">News feed</a></li>
            <li class="header-link"><a href="archive">Archive</a></li>
            <li class="header-link"><a href="login">Log in</a></li>
            <li class="header-link"><a href="sign-up">Sign up</a></li>
        </ul>
    </nav>
</header>
<body>
<%@include file="elements/greeting.jsp" %>
<div id="content">
    <%@include file="elements/newsTable.jsp" %>
</div>
</body>
<%@include file="elements/footer.jsp" %>
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/app.js"></script>
</html>