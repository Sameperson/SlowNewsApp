<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="usersTable">
    <tr class="tableHeader">
        <th class="userNode">Registration time</th>
        <th class="userNode">Username</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td class="userNode">
                ${user.date}
            </td>
            <td class="userNode">
                ${user.username}
            </td>
        </tr>
    </c:forEach>
</table>
