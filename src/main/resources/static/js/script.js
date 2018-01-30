var uploadFile = function (elem) {
  var formData = new FormData();
  formData.append('uploadfile', $('#' + elem)[0].files[0]);
  $.ajax({
    url: '/image/upload',
    data: formData,
    cache: false,
    contentType: false,
    processData: false,
    method: 'POST'
  }).done(function (data, textStatus, jqXHR) {
    var location = jqXHR.getResponseHeader('Location');
    console.log(location);
    $('input[name=' + elem + ']').attr('value', location);
    $('label[for=' + elem + '] img').attr('src', location);
  });
};

$(function () {
  $("#posterImgUrl").on("change", function () {
    uploadFile('posterImgUrl');
  });
  $("#bannerImgUrl").on("change", function () {
    uploadFile('bannerImgUrl');
  });

  $('.movie-select').select2({
    ajax: {
      url: '/webservice/movie/search',
      dataType: 'json',
      data: function (params) {
        return {q: params.term};
      },
      processResults: function (data) {
        return {
          results: data.items.map(function (item) {
            return {id: item.id, text: item.title};
          })
        };
      }
    }
  });

  $('.theater-select').select2({
    ajax: {
      url: '/webservice/theater/search',
      dataType: 'json',
      data: function (params) {
        return {q: params.term};
      },
      processResults: function (data) {
        return {
          results: data.items.map(function (item) {
            return {id: item.id, text: item.title};
          })
        };
      }
    }
  });

  $('.date-picker').datetimepicker({
    timepicker: false,
    format: 'Y-m-d'
  });

  $('.time-picker').datetimepicker({
    datepicker: false,
    format: 'H:i'
  });

  JsBarcode(".barcode").init();
});