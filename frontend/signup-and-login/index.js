function signup() {
    $.ajax({
        url: 'http://localhost:8080/signup',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify({
            f_name: $('#first-name-input').val(),
            l_name: $('#last-name-input').val(),
            username: $('#username-input').val(),
            p_word: $('#password-input').val(),
            email: $('#email-input').val()
        }),
        contentType: 'application/json',
        mimeType: 'application/json'
    })
        .then(function handleFeedResponse(response) {
            var PAGE_DATA = response;
            console.log(PAGE_DATA);
            window.location.replace(
                '../description-form/student-description.html'
                //?username=' + $('#username-input').val()
            );
        })
        .catch(function handleFeedError(err) {
            console.log(err);
        });
    console.log(
        JSON.stringify({
            f_name: $('#first-name-input').val(),
            l_name: $('#last-name-input').val(),
            username: $('#username-input').val(),
            p_word: $('#password-input').val(),
            email: $('#email-input').val()
        })
    );
}

$('#sign-up-form').on('submit', function(event) {
    event.preventDefault();
    signup();
});

$('#login-form').on('submit', function(event) {
    event.preventDefault();
    login();
});
function login() {
    console.log(
        JSON.stringify({
            username: $('#login-username-input').val(),
            p_word: $('#login-password-input').val()
        })
    );
    $.ajax({
        url: 'http://localhost:8080/login',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify({
            username: $('#login-username-input').val(),
            p_word: $('#login-password-input').val()
        }),
        contentType: 'application/json',
        mimeType: 'application/json'
    })
        .then(function handleFeedResponse(response) {
            window.location.replace(
                '../feed/feed.html?username=' + response.username
            );
        })
        .catch(function handleFeedError(err) {
            console.log(err);
        });
}
