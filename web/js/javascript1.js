
function getWeather() {
    var city = $("#city").val();
    if (city != '') {
        var metric = $("#metric").val();
        var dataWeather = getJSON({'city': city, 'metric': metric, 'action': 'single'});
        if (dataWeather == null) {
            $("#try").text("Please, try again!");
        } else {
            onTable(dataWeather);
        }
    } else {
        $("#city").css('outline', 'solid 0.5px red');
    }
}

function onTable(data) {

    for (var obj in data.list) {
        $("#cit").text(data.list[obj].name);
        $("#country").text(data.list[obj].sys.country);
        $("#lat").text(data.list[obj].coord.lat);
        $("#lon").text(data.list[obj].coord.lon);
        $("#cw").text(data.list[obj].weather[0].main);
        $("#ws").text(data.list[obj].wind.speed);
        break;

    }
    $("#mainToCollapse").prop('collapse', false);
}

function getJSON(data) {
    var info;

    $.ajax({
        url: "getWeather",
        type: 'POST',
        dataType: 'json',
        async: false,
        data: data,
        beforeSend: function (xhr) {
            $("#btnMain").attr('disabled', true);
            $("#city").removeAttr('style');
            $("#try").text('');
        },
        success: function (xhr) {
            info = xhr;
            $("#btnMain").attr('disabled', false);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
            info = null;
            $("#btnMain").attr('disabled', false);

        }
    });
    return info;
}

