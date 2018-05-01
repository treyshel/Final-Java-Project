// function recruiterSignup() {
//     var username = $('.username-input').val();
//     window.localStorage.setItem('username', username);
//     $.ajax({
//         url: 'http://localhost:8080/recruiter-signup',
//         method: 'Post',
//         dataType: 'json',
//         crossDomain: true,

//         data: JSON.stringify({
//             title: $('#title-input').val(),
//             f_name: $('.first-name-input').val(),
//             l_name: $('.last-name-input').val(),
//             username: username,
//             p_word: $('.password-input').val(),
//             email: $('.email-input').val(),
//             langs_used: $('.programming-langs-input').val(),
//             company_name: $('#company-name-input').val(),
//             company_location: $('.location-input').val(),
//             position_level: $('.position-level-input').val(),
//             website_url: $('#website-url-input')
//         }),
//         contentType: 'application/json',
//         mimeType: 'application/json'
//     })
//         .then(function handleFeedResponse(response) {
//             var PAGE_DATA = response;
//             console.log(PAGE_DATA);
//             window.location.replace(
//                 '../feed/feed.html?username=' + $('.username-input').val()
//             );
//         })
//         .catch(function handleFeedError(err) {
//             console.log(err);
//         });
//     console.log(
//         JSON.stringify({
//             title: $('#title-input').val(),
//             f_name: $('.first-name-input').val(),
//             l_name: $('.last-name-input').val(),
//             username: $('.username-input').val(),
//             p_word: $('.password-input').val(),
//             email: $('.email-input').val(),
//             langs_used: $('.programming-langs-input').val(),
//             company_name: $('#company-name-input').val(),
//             company_location: $('.location-input').val(),
//             position_level: $('.position-level-input').val(),
//             website_url: $('#website-url-input')
//         })
//     );
// }

// function recruiterLogin() {
//     console.log(
//         JSON.stringify({
//             username: $('.login-username-input').val(),
//             p_word: $('.login-password-input').val()
//         })
//     );
//     $.ajax({
//         url: 'http://localhost:8080/recruiter-login',
//         method: 'Post',
//         dataType: 'json',
//         crossDomain: true,
//         data: JSON.stringify({
//             username: $('.login-username-input').val(),
//             p_word: $('.login-password-input').val()
//         }),
//         contentType: 'application/json',
//         mimeType: 'application/json'
//     })
//         .then(function handleFeedResponse(response) {
//             window.location.replace(
//                 '../feed/feed.html?username=' + response.username
//             );
//         })
//         .catch(function handleFeedError(err) {
//             console.log(err);
//         });
// }

// $('.recruiter-signup-form').on('submit', function(event) {
//     event.preventDefault();
//     recruiterSignup();
// });

// $('.recruiter-login-form').on('submit', function(event) {
//     event.preventDefault();
//     recruiterLogin();
// });

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
            programming_lang: $('#student-programming-langs-input').val(),
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
            programming_lang: $('#student-programming-langs-input').val(),
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
            username: $('#studnet-login-username-input').val(),
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

$('#student-signup-form').on('submit', function(event) {
    event.preventDefault();
    studentSignup();
});

$('#student-login-form').on('submit', function(event) {
    event.preventDefault();
    studentLogin();
});

$('.next-form-button').on('click', function() {
    $('#first-signup-form').attr('hidden', true);
    $('#second-signup-form').attr('hidden', false);
    $('.student-signup-button').attr('hidden', false);
});

$('.student').on('click', function() {
    $('.student-info').show(500);
    $('.student-or-recruiter').hide(500);
});

$('.recruiter').on('click', function() {
    $('.recruiter-info').show(500);
    $('.student-or-recruiter').hide(500);
});
