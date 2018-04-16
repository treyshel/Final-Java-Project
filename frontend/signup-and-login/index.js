function signup() {
    var username = $('#username-input').val();
    window.localStorage.setItem('username', username);
    $.ajax({
        url: 'http://localhost:8080/signup',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,

        data: JSON.stringify({
            username: username,
            f_name: $('#first-name-input').val(),
            l_name: $('#last-name-input').val(),
            p_word: $('#password-input').val(),
            email: $('#email-input').val(),
            programming_langs: $('#programming-langs-input').val(),
            desired_location: $('#desired-location-input').val(),
            linkedin_url: $('#linkedin-url-input').val(),
            resume_url: $('#resume-url-input').val(),
            github_url: $('#github-url-input').val(),
            portfolio_url: $('#portfolio-url-input').val()
        }),
        contentType: 'application/json',
        mimeType: 'application/json'
    })
        .then(function handleFeedResponse(response) {
            var PAGE_DATA = response;
            console.log(PAGE_DATA);
            window.location.replace(
                '../feed/feed.html?username=' + $('#username-input').val()
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
            email: $('#email-input').val(),
            programming_lang: $('#programming-langs-input').val(),
            desired_location: $('#desired-location-input').val(),
            linkedin_url: $('#linkedin-url-input').val(),
            resume_url: $('#resume-url-input').val(),
            github_url: $('#github-url-input').val(),
            portfolio_url: $('#portfolio-url-input').val()
        })
    );
}

$('#sign-up-form').on('submit', function(event) {
    event.preventDefault();
    signup();
});

$('.next-form-button').on('click', function() {
    $('#first-signup-form').attr('hidden', true);
    $('#second-signup-form').attr('hidden', false);
    $('#signup-button').attr('hidden', false);
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
