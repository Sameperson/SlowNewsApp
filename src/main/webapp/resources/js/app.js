$(function () {
    var enableExpandableNews = function() {
        $(".hideableBody").hide();
        $(".clickable-title").on("click", function () {
            var $hideableNewsBody = $('#hideable-from-' + $(this).attr("id"));
            $hideableNewsBody.toggle();
        });
    };
    enableExpandableNews();
    $('.header-link a, .logo, #user-list-link').click(function(event){
        event.preventDefault();
        window.history.pushState('Object', 'Title', $(this).attr('href'));
        $.ajax({url: $(this).attr('href'), success: function(result){
            document.getElementById("content").innerHTML = result;
            enableExpandableNews();
        }});
    })
});