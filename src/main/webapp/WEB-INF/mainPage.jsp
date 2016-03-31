<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
      <c:forEach items="${newsList}" var="news">
        <tr>
          <td class=time>
            <c:out value="${news.timeOnly}" />
          </td>
          <td class=newsInstance>
            <a href="news/<c:out value="${news.name}" />"><c:out value="${news.title}" /></a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
  <%@include file="elements/footer.jsp" %>
</html>
