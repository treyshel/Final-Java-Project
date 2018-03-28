PAGE_DATA = new Object();

// **********change background color of active side tab***********

function sidebarControl() {
    $("#section1").click(function () {
        $(".example1").hide(500);
        $(".example2").hide(500);
        $(".feedPage").show(500);
    });

    $("#section2").click(function () {
        $(".feedPage").hide(500);
        $(".example2")
        $(".example1").show(500);
    });

    $("#section3").click(function () {
        $(".feedPage").hide(500);
        $(".example1").hide(500);
        $(".example2").show(500);
    });
}


// ************shows feed************

function showFeedData() {
    console.log(PAGE_DATA);
    return "<h2>Name: " + PAGE_DATA.f_name + " " + PAGE_DATA.l_name + "</h2>" +
        "<h2>Username: " + PAGE_DATA.username + "</h2>" +
        "<h2>Email: " + PAGE_DATA.email + "</h2>"
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

function logout() {
    var username = getParameterByUsername('username');
    $.ajax({
        url: 'http://localhost:8080/logout/' + username,
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function () {
        window.location.replace(
            '../signup-and-login/index.html'
        )
    })
}


