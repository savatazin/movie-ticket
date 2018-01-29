<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html class="no-js" lang="">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>${movie.title}</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <style>
    .movie-list {
      display: block;
      overflow: hidden;
      padding: 0;
      margin: 0;
    }

    .movie-list li {
      display: inline-block;
      margin: 5px;
      width: 190px;
    }

    .movie-title {
      margin: 2px 0;
      font-size: 14pt;
      text-transform: uppercase;
      text-align: center;
      font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    }
  </style>
</head>
<body>


<div class="container">
  <div class="row">
    <h1>TnA Theaters</h1>
    <div>
      <svg class="barcode"
           jsbarcode-format="code39"
           jsbarcode-value="${bookKey}"
           jsbarcode-textmargin="0"
           jsbarcode-height="50"
           jsbarcode-margin="0"
           jsbarcode-fontoptions="bold" height="25px">
      </svg>
    </div>
    <h1>${movie.title}</h1>
    <div class="col-md-6">
      <p class="text-right">Time: ${show.showTimeStart} to ${show.showTimeEnd}</p>
      <p class="text-right">Time: ${show.showDate}</p>
    </div>
    <div class="col-md-6">
      <p>Theater: ${theater.title}</p>
      <p>Ticket Price: TK 350</p>
    </div>
    <h3>Ticket Serial Number: ${bookKey}</h3>
  </div>
</div>

<form action="/book/${show.id}/purchase">
  <input type="text" hidden value="${bookKey}">
  <button type="submit" class="btn btn-success">Purchase</button>
</form>


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jsbarcode@3.8.0/dist/JsBarcode.all.min.js"></script>
<script>
  JsBarcode(".barcode").init();
</script>
</body>
</html>
