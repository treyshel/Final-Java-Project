PAGE_DATA = new Object();

function showFeedData() {
    console.log(PAGE_DATA);
    return "<h2>" + PAGE_DATA.f_name + "</h2>"
}

function Feed(response) {
    console.log(response);
    PAGE_DATA = response;
    $('.feedPage').html(showFeedData())
}

function getParameterByUsername(username) {
    var url = window.location.href;
    username = username.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + username + '(=([^&#]*)|&|#|$)');
    results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}


$(function () {
    var username = getParameterByUsername('username');
    console.log(username);
    $.post('http://localhost:8080/feed/' + username).then(function handleResponse(response) {
        var response = response;
        console.log(response)
        Feed(response);
    })
})