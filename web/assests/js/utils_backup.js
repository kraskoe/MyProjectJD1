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
        dataType: "json",
        data: {countryId: countryId}
    }).done(function (data) {
        $(".cityOption").remove();
        $.each(data, function(c, city){
            $(".cityForm").append("<option class='cityOption' value=" + city.id +">" + city.name);
        });
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}
