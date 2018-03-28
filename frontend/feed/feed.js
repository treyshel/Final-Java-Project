function Feed

$(function () {
    var username = getParameterByUsername('username');
    console.log(username);
    $.get('http://localhost:8080/feed/' + username).then(function handleResponse(response) {
        var response = response;
        Feed(response);
    })
})