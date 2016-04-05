<c:if test="${empty username}">
  Greetings, guest! <a href="/login">(login)</a>
</c:if>
<c:if test="${not empty username}">
  Greetings <b>${username}</b>! <a href="/logout">(logout)</a>
</c:if>

<div class="weather">${weather}</div>