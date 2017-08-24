$(document).ready(function(){
    $('.countryForm').change(function () {
        getCities();
    });
});


function getCities(){
    var countryId = $(".countryForm option:selected").val();
    var baseUrl = document.location.origin;
    $.ajax({
        type: "POST",
        url: baseUrl + '/web/frontController?command=getCities',
        data: {countryId: countryId}
    }).done(function (data) {
        $(".cityForm").html(data);
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}
