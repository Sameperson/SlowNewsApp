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
    <a href="/" class="logo">
        <h1>Slow News</h1>
    </a>
    <nav>
        <ul>
            <li><a href="/" class="selected">News feed</a></li>
            <li><a href="archive">Archive</a></li>
            <li><a href="login">Log in</a></li>
            <li><a href="sign-up">Sign up</a></li>
        </ul>
    </nav>
</header>
<body>
<%@include file="elements/greeting.jsp" %>
<table class="newsTable">
    <c:set var="count" value="0" scope="page"/>
    <c:forEach items="${newsList}" var="news">
        <c:set var="count" value="${count + 1}" scope="page"/>
        <tr>
            <td class=time>
                <c:out value="${news.pubTime}"/>
            </td>
            <td class=newsInstance>
                <div class="clickable-title" id="clickable${count}">
                        ${news.title}
                </div>
            </td>
        </tr>
        <tr class="newsInstance">
            <td colspan="2">
                <div class="hideableBody" id="hideable-from-clickable${count}">
                        ${news.description}<br>
                    <a href="news/${news.name}"/><b>Read more</b></a>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<%@include file="elements/footer.jsp" %>
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/app.js"></script>
</html>
