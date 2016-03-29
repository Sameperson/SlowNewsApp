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
      <li><a href="/">News feed</a></li>
      <li><a href="archive">Archive</a></li>
      <li><a href="login">Login</a></li>
      <li><a href="sign-up" class="selected">Sign-Up</a></li>
    </ul>
  </nav>
</header>
<body>
    <div class="login-form">
        <form name="registrationForm" method="post" action="/sign-up">
            <ul style="list-style-type:none">
                <li><label>Username</label>
                    <input type="text" name="username" placeholder="Your username" required></li>
                <li><label>Password</label>
                    <input type="password" name="password" placeholder="Your password" required></li>
                <li>
                    <input type="submit" value="Sign-In"></li>
            </ul>
        </form>
    </div>
    <%@include file="html-elements/footer.jsp" %>
</body>
</html>
