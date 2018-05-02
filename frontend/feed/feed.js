PAGE_DATA = new Object();

// **********side tab functionality***********

$('#ProfileInfo').click(function() {
    $('.jobPostings').hide(500);
    $('.connections').hide(500);
    $('#jobPostings').removeClass('active');
    $('#networkConnections').removeClass('active');
    $('#ProfileInfo').addClass('active');
    $('.feedPage').show(500);
});

$('#jobPostings').click(function() {
    $('.feedPage').hide(500);
    $('.connections').hide(500);
    $('#ProfileInfo').removeClass('active');
    $('#networkConnections').removeClass('active');
    $('#jobPostings').addClass('active');
    $('.jobPostings').show(500);
});

$('#networkConnections').click(function() {
    $('.feedPage').hide(500);
    $('.jobPostings').hide(500);
    $('#jobPostings').removeClass('active');
    $('#ProfileInfo').removeClass('active');
    $('#networkConnections').addClass('active');
    $('.connections').show(500);
});

// ************student work************

function showStudentFeedData() {
    console.log(PAGE_DATA);
    return (
        '<h2>Name: ' +
        PAGE_DATA.f_name +
        ' ' +
        PAGE_DATA.l_name +
        '</h2>' +
        '<h2>Username: ' +
        PAGE_DATA.username +
        '</h2>' +
        '<h2:>Email: ' +
        PAGE_DATA.email +
        '</h2>' +
        '<h2>Fav Lang: ' +
        PAGE_DATA.programming_langs +
        '</h2>' +
        '<h2>Desired Location: ' +
        PAGE_DATA.desired_location +
        '</h2>' +
        '<h2>Position Level: ' +
        PAGE_DATA.position_level +
        '</h2>' +
        '<a href="https://' +
        PAGE_DATA.portfolio_url +
        '"> Portfolio: ' +
        PAGE_DATA.portfolio_url +
        '</a><br>' +
        '<a href="https://' +
        PAGE_DATA.github_url +
        '"> Github: ' +
        PAGE_DATA.github_url +
        '</a><br>' +
        '<a href="https://' +
        PAGE_DATA.resume_url +
        '"> Portfolio: ' +
        PAGE_DATA.resume_url +
        '</a>'
    );
}

function showAllJobPostings() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">Company: ' +
            PAGE_DATA[i].company_name +
            '</div>' +
            '<div class="panel-body">Information:<br><p>Recruiter Email: ' +
            PAGE_DATA[i].email +
            '</p><p>Company Location: ' +
            PAGE_DATA[i].company_location +
            '</p><p>Languages for Position: ' +
            PAGE_DATA[i].langs_used +
            '</p><p>Recruiter Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function showMatchingRecruiterLocation() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">Company: ' +
            PAGE_DATA[i].company_name +
            '</div>' +
            '<div class="panel-body">Information:<br><p>Recruiter Email: ' +
            PAGE_DATA[i].email +
            '</p><p>Company Location: ' +
            PAGE_DATA[i].company_location +
            '</p><p>Recruiter Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function showMatchingRecruiterPositionLevel() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">Company: ' +
            PAGE_DATA[i].company_name +
            '</div>' +
            '<div class="panel-body">Information:<br><p>Languages for Position Level: ' +
            PAGE_DATA[i].position_level +
            '</p><p>Recruiter Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function showMatchingRecruiterLanguage() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">Company: ' +
            PAGE_DATA[i].company_name +
            '</div>' +
            '<div class="panel-body">Information:<br><p>Languages for Position: ' +
            PAGE_DATA[i].langs_used +
            '</p><p>Recruiter Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function Feed(response) {
    console.log(response);
    PAGE_DATA = response;
    $('.feedPage').html(showStudentFeedData());
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

$(function() {
    var username = getParameterByUsername('username');
    console.log(username);
    $.post('http://localhost:8080/student-feed/' + username).then(
        function handleResponse(response) {
            var response = response;
            console.log(response);
            Feed(response);
        }
    );
});

function studentLogout() {
    var username = getParameterByUsername('username');
    $.ajax({
        url: 'http://localhost:8080/student-logout/' + username,
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function() {
        window.location.replace('../signup-and-login/index.html');
    });
}

function studentDeleteAccount() {
    var username = getParameterByUsername('username');
    $.ajax({
        url: 'http://localhost:8080/student-deleteAccount/' + username,
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function() {
        window.location.replace('../signup-and-login/index.html');
    });
}

function Postings() {
    $.ajax({
        url: 'http://localhost:8080/allRecruiters',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showAllJobPostings());
    });
}

// ********* ajax request for filtered postings *************

function studentFilteredByMatchingLocation() {
    $.ajax({
        url: 'http://localhost:8080/student-filter-location',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showMatchingStudentLocation());
    });
}

function studentFilteredByMatchingPositionLevel() {
    $.ajax({
        url: 'http://localhost:8080/student-filter-level',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showMatchingStudentPositionLevel());
    });
}

function studentFilteredByMatchingLanguage() {
    $.ajax({
        url: 'http://localhost:8080/student-filter-language',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showMatchingStudentLanguage());
    });
}

// ****************recruiter feed

function showRecruiterFeedData() {
    console.log(PAGE_DATA);
    return (
        '<h2>Name: ' +
        PAGE_DATA.title +
        ' ' +
        PAGE_DATA.f_name +
        ' ' +
        PAGE_DATA.l_name +
        '</h2>' +
        '<h2>Username: ' +
        PAGE_DATA.username +
        '</h2>' +
        '<h2:>Email: ' +
        PAGE_DATA.email +
        '</h2>' +
        '<h2>Company Location: ' +
        PAGE_DATA.company_location +
        '</h2>' +
        '<h2>Level Looking For: ' +
        PAGE_DATA.position_level +
        '</h2>' +
        '<h2>Company Name: ' +
        PAGE_DATA.company_name +
        '</h2><br>' +
        '<h2>Position Languages: ' +
        PAGE_DATA.langs_used +
        '</h2><br>' +
        '<a href="https://' +
        PAGE_DATA.website_url +
        '">Website: ' +
        PAGE_DATA.website_url +
        '</a>'
    );
}

function showAllDeveloperPostings() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name;
        '</div>' +
            '<div class="panel-body">Information:<br><p>Developer Email: ' +
            PAGE_DATA[i].email +
            '</p><p>Desired Location: ' +
            PAGE_DATA[i].desired_location +
            '</p><p>Desired Languages Position: ' +
            PAGE_DATA[i].programming_langs +
            '</p><p>Resume Url ' +
            PAGE_DATA[i].resume_url +
            '</p><a href="https//:' +
            PAGE_DATA[i].portfolio_url +
            '>' +
            PAGE_DATA[i].portfolio_url +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function showMatchingDeveloperLocation() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">name: ' +
            PAGE_DATA[i].f_name +
            '</div>' +
            '<div class="panel-body">Information:<br><p>Developer Email: ' +
            PAGE_DATA[i].email +
            '</p><p>Desired Location: ' +
            PAGE_DATA[i].desired_location +
            '</p><p>Developer Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function showMatchingDeveloperPositionLevel() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">Dev name: ' +
            PAGE_DATA[i].f_name +
            '</div>' +
            '<div class="panel-body">Information:<br><p>Position Level: ' +
            PAGE_DATA[i].position_level +
            '</p><p>Recruiter Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function showMatchingDeveloperLanguage() {
    var html = '';
    for (var i = 0; i < PAGE_DATA.length; i++) {
        html +=
            '<div class="panel panel-default">' +
            '<div class="panel-heading">Last name: ' +
            PAGE_DATA[i].l_name +
            '</div>' +
            '<div class="panel-body">Information:<br><p>Languages: ' +
            PAGE_DATA[i].programming_langs +
            '</p><p>Dev Name: ' +
            PAGE_DATA[i].f_name +
            ' ' +
            PAGE_DATA[i].l_name +
            '</p><button type="submit" class="btn btn-primary">Connect</button></div>' +
            '</div>';
    }
    return html;
}

function recruiterFeed(response) {
    console.log(response);
    PAGE_DATA = response;
    $('.feedPage').html(showRecruiterFeedData());
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

$(function() {
    var username = getParameterByUsername('username');
    console.log(username);
    $.post('http://localhost:8080/recruiter-feed/' + username).then(
        function handleResponse(response) {
            var response = response;
            console.log(response);
            recruiterFeed(response);
        }
    );
});

function recruiterLogout() {
    var username = getParameterByUsername('username');
    $.ajax({
        url: 'http://localhost:8080/recruiter-logout/' + username,
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function() {
        window.location.replace('../signup-and-login/index.html');
    });
}

function recruiterDeleteAccount() {
    var username = getParameterByUsername('username');
    $.ajax({
        url: 'http://localhost:8080/recruiter-deleteAccount/' + username,
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function() {
        window.location.replace('../signup-and-login/index.html');
    });
}

function developerPostings() {
    $.ajax({
        url: 'http://localhost:8080/allStudents',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showAllDeveloperPostings());
    });
}

// ********* ajax request for filtered postings *************

function recruiterFilteredByMatchingLocation() {
    $.ajax({
        url: 'http://localhost:8080/recruiter-filter-location',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showMatchingDeveloperLocation());
    });
}

function recruiterFilteredByMatchingPositionLevel() {
    $.ajax({
        url: 'http://localhost:8080/recruiter-filter-level',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showMatchingDeveloperPositionLevel());
    });
}

function recruiterFilteredByMatchingLanguage() {
    $.ajax({
        url: 'http://localhost:8080/recruiter-filter-language',
        method: 'Get',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json'
    }).then(function(response) {
        console.log(response);
        PAGE_DATA = response;
        $('.postings').html(showMatchingDeveloperLanguage());
    });
}
