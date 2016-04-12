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
        </div>
      </td>
    </tr>
  </c:forEach>
</table>