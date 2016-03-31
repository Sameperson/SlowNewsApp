<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <li><a href="login" class="selected">Login</a></li>
      <li><a href="sign-up">Sign-Up</a></li>
    </ul>
  </nav>
</header>
<body>
<body>
<div class="sign-up-form">
  <form name="loginForm" method="post" action="/login">
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
