<c:if test="${empty username}">
  Greetings, guest! <a href="/login">(login)</a>
</c:if>
<c:if test="${not empty username}">
  Greetings <b>${username}</b>! <a href="/logout">(logout)</a>
</c:if>

<div class="weather">${weather}</div>
<div><audio controls>
  <source src="/resources/audio/we_can_dance.mp3"  type="audio/mpeg">
  Your browser does not support the audio element.
</audio></div>