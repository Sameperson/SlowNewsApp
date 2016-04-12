<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sign-up-form">
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
