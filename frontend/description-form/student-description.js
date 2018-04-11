function studentDesc() {
    $.ajax({
        url: 'http://localhost:8080/studentDesc',
        method: 'Post',
        dataType: 'json',
        crossDomain: true,
        data: JSON.stringify({
            username: window.localStorage.getItem('username'),
            programming_lang: $('#programming-langs-input').val(),
            academics: $('#academics-input').val(),
            location: $('#desired-location-input').val()
        }),
        contentType: 'application/json',
        mimeType: 'application/json'
    })
        .then(function handleFeedResponse(response) {
            var PAGE_DATA = response;
            console.log(PAGE_DATA);
            window.location.replace('../feed/feed.html');
        })
        .catch(function handleFeedError(err) {
            console.log(err);
        });
    console.log(
        JSON.stringify({
            programming_lang: $('#programming-langs-input').val(),
            academics: $('#academics-input').val(),
            location: $('#desired-location-input').val()
        })
    );
}

$('.student-description-form').on('submit', function(event) {
    event.preventDefault();
    studentDesc();
});
