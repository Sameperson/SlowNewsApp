$(function () {

    $(".hideableBody").hide();

    $(".clickable-title").on("click", function() {
        var $hideableNewsBody = $('#hideable-from-' + $(this).attr("id"));

        if ($hideableNewsBody.is(":visible")) {
            $hideableNewsBody.hide();
        } else {
            $hideableNewsBody.show();
        }
    });

});