$(function () {
    $(".hideableBody").hide();

    var audio = new Audio('audio_file.mp3');
    audio.play();


    $(".clickable-title").on("click", function () {
        var $hideableNewsBody = $('#hideable-from-' + $(this).attr("id"));
        $hideableNewsBody.toggle();
    });

    //var uri = window.location.pathname;
    //(function () {
    //    var xhttp = new XMLHttpRequest();
    //    xhttp.onreadystatechange = function () {
    //        if (xhttp.readyState == 4 && xhttp.status == 200) {
    //            document.getElementById("content").innerHTML = xhttp.responseText;
    //        }
    //    };
    //    xhttp.open("GET", uri, true);
    //    xhttp.send();
    //})();

    $('.header-link a, .logo').click(function(event){
        console.log("got click!");
        event.preventDefault();
        window.history.pushState('Object', 'Title', $(this).attr('href'));

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                document.getElementById("content").innerHTML = xhttp.responseText;
            }
        };
        xhttp.open("GET", $(this).attr('href'), true);
        xhttp.send();
    })
});