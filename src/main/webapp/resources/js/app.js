$(function () {

    $(".hideableBody").hide();

    $(".clickable-title").on("click", function() {
        var $hideableNewsBody = $('#hideable-from-' + $(this).attr("id"));
        $hideableNewsBody.toggle();
    });

});