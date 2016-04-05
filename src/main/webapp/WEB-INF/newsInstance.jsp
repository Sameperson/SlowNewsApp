<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Slow News</title>
    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link href='http://fonts.googleapis.com/css?family=Changa+One|Open+Sans:400italic,700italic,400,700,800' rel='stylesheet' type='text/css'>
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
            <li><a href="/">News feed</a></li>
            <li><a href="/archive">Archive</a></li>
            <li><a href="/login">Log in</a></li>
            <li><a href="/sign-up">Sign up</a></li>
        </ul>
    </nav>
</header>
<body>
<%@include file="elements/greeting.jsp" %>
    <div>
        <div class="newsPage">
            <div class="newsTitle">
                ${newsInstance.title}
            </div>
            <div>
                ${newsInstance.pubDate}
            </div>
            <div class="newsImage">
                <img src="/resources/images/${newsInstance.name}.jpg"
                     alt="${newsInstance.name}" height="420">
            </div>
            <div class="newsBody">
                ${newsInstance.description}
            </div>
            <c:if test="${(not empty username) && (not hideArchiveButton)}">
                <form name="news" method="post" action="/news/">
                    <input type="hidden" name="name" value="${newsInstance.name}">
                    <div>
                        <input type="submit" value="Archive">
                    </div>
                </form>
            </c:if>
        </div>
    </div>
</body>
<%@include file="elements/footer.jsp" %>
</html>
