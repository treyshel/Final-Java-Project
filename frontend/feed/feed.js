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

// ************shows feed************

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
        '<h2>' +
        'Email: ' +
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
