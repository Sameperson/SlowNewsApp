<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="newsPage">
        <div class="newsTitle">
            ${newsInstance.title}
        </div>
        <div>
            ${newsInstance.pubDate}
        </div>
        <div class="newsImage">
            <img src="/resources/images/${newsInstance.title}.jpg"
                 alt="${newsInstance.title}" height="420">
        </div>
        <div class="newsBody">
            ${newsInstance.description}
        </div>
        <c:if test="${(not empty username) && (not hideArchiveButton)}">
            <form name="news" method="post" action="/news/">
                <input type="hidden" name="name" value="${newsInstance.title}">

                <div>
                    <input type="submit" value="Archive">
                </div>
            </form>
        </c:if>
    </div>
</div>

