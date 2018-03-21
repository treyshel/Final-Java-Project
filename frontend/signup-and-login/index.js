var PAGE_DATA = new Object();

function signup() {
    $.post(
        'http://localhost8080/signup',
        JSON.stringify({
            f_name: $('#first-name-input').val(),
            l_name: $('#last-name-input').val(),
            username: $('#username-input').val(),
            password: $('#password-input').val(),
            email: $('#email-input').val(),
        })
    ).then(function signUpRequest(request) {
        var PAGE_DATA = request;
        window.localStorage.setItem('key', PAGE_DATA.key);
        console.log(PAGE_DATA);
        window.location =
            '../feed/feed.html?user=' + $('#username-input').val();
    });
}

$('#sign-up-form').on('submit', function (event) {
    event.preventDefault();
    signup();
});

