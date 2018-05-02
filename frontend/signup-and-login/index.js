$('#student-signup-form').on('submit', function(event) {
    event.preventDefault();
    studentSignup();
});

$('#student-login-form').on('submit', function(event) {
    event.preventDefault();
    studentLogin();
});

$('#recruiter-signup-form').on('submit', function(event) {
    event.preventDefault();
    recruiterSignup();
});

$('#recruiter-login-form').on('submit', function(event) {
    event.preventDefault();
    recruiterLogin();
});

$('.student-next-form-button').on('click', function() {
    $('#student-first-signup-form').attr('hidden', true);
    $('#student-second-signup-form').attr('hidden', false);
    $('.student-signup-button').attr('hidden', false);
});

$('.recruiter-next-form-button').on('click', function() {
    $('#recruiter-first-signup-form').attr('hidden', true);
    $('#recruiter-second-signup-form').attr('hidden', false);
    $('.recruiter-signup-button').attr('hidden', false);
});

$('.student').on('click', function() {
    $('.student-info').show(500);
    $('.student-or-recruiter').hide(500);
});

$('.recruiter').on('click', function() {
    $('.recruiter-info').show(500);
    $('.student-or-recruiter').hide(500);
});

// ************ recruiter work
function recruiterSignup() {
    var username = $('#recruiter-username-input').val();
    window.localStorage.setItem('username', username);
    $.ajax({
        url: 'http://localhost:8080/recruiter-signup',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify({
            title: $('#title-input').val(),
            f_name: $('#recruiter-first-name-input').val(),
            l_name: $('#recruiter-last-name-input').val(),
            username: username,
            p_word: $('#recruiter-password-input').val(),
            email: $('#recruiter-email-input').val(),
            langs_used: $('#recruiter-programming-langs-input').val(),
            company_name: $('#company-name-input').val(),
            company_location: $('#recruiter-location-input').val(),
            position_level: $('#recruiter-position-level-input').val(),
            website_url: $('#website-url-input')
        }),
        contentType: 'application/json',
        mimeType: 'application/json'
    })
        .then(function handleFeedResponse(response) {
            var PAGE_DATA = response;
            console.log(PAGE_DATA);
            window.location.replace(
                '../feed/feed.html?username=' +
                    $('#recruiter-username-input').val()
            );
        })
        .catch(function handleFeedError(err) {
            console.log(err);
        });
    console.log(
        JSON.stringify({
            title: $('#title-input').val(),
            f_name: $('#recruiter-first-name-input').val(),
            l_name: $('#recruiter-last-name-input').val(),
            username: username,
            p_word: $('#recruiter-password-input').val(),
            email: $('#recruiter-email-input').val(),
            langs_used: $('#recruiter-programming-langs-input').val(),
            company_name: $('#company-name-input').val(),
            company_location: $('#recruiter-location-input').val(),
            position_level: $('#recruiter-position-level-input').val(),
            website_url: $('#website-url-input')
        })
    );
}

function recruiterLogin() {
    console.log(
        JSON.stringify({
            username: $('#recruiter-login-username-input').val(),
            p_word: $('#recruiter-login-password-input').val()
        })
    );
    $.ajax({
        url: 'http://localhost:8080/recruiter-login',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify({
            username: $('#recruiter-login-username-input').val(),
            p_word: $('#recruiter-login-password-input').val()
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

$('#recruiter-signup-form').on('submit', function(event) {
    event.preventDefault();
    recruiterSignup();
});

$('#recruiter-login-form').on('submit', function(event) {
    event.preventDefault();
    recruiterLogin();
});

// *********** student work
function studentSignup() {
    var username = $('#student-username-input').val();
    console.log(username);
    window.localStorage.setItem('username', username);
    $.ajax({
        url: 'http://localhost:8080/student-signup',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,

        data: JSON.stringify({
            f_name: $('#student-first-name-input').val(),
            l_name: $('#student-last-name-input').val(),
            username: username,
            p_word: $('#student-password-input').val(),
            email: $('#student-email-input').val(),
            programming_langs: $('#student-programming-langs-input').val(),
            desired_location: $('#student-location-input').val(),
            position_level: $('#student-position-level-input').val(),
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
                '../feed/feed.html?username=' +
                    $('#student-username-input').val()
            );
        })
        .catch(function handleFeedError(err) {
            console.log(err);
        });
    console.log(
        JSON.stringify({
            f_name: $('#student-first-name-input').val(),
            l_name: $('#student-last-name-input').val(),
            username: $('#student-username-input').val(),
            p_word: $('#student-password-input').val(),
            email: $('#student-email-input').val(),
            programming_langs: $('#student-programming-langs-input').val(),
            desired_location: $('#student-location-input').val(),
            position_level: $('#student-position-level-input').val(),
            resume_url: $('#resume-url-input').val(),
            github_url: $('#github-url-input').val(),
            portfolio_url: $('#portfolio-url-input').val()
        })
    );
}

function studentLogin() {
    console.log(
        JSON.stringify({
            username: $('#student-login-username-input').val(),
            p_word: $('#student-login-password-input').val()
        })
    );
    $.ajax({
        url: 'http://localhost:8080/student-login',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify({
            username: $('#student-login-username-input').val(),
            p_word: $('#student-login-password-input').val()
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
