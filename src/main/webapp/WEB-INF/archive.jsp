<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="newsTable">
    <c:forEach items="${newsList}" var="news">
        <tr>
            <td class=time>
                <c:out value="${news.pubTime}"/>
            </td>
            <td class=newsInstance>
                <a href="news/<c:out value="${news.name}" />"><c:out value='${news.title}'/></a>
            </td>
        </tr>
    </c:forEach>
</table>

