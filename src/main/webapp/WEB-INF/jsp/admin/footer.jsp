<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/jquery.fakecrop.js"></script>
<script>

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
  });
</script>

</body>
</html>