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
    <h1>Ticket Purchase History</h1>

    <table class="table">
      <thead>
      <tr>
        <th>Movie Name</th>
        <th>Show Time</th>
        <th>Theater</th>
        <th>Seat No</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${bookings}" var="booking">
        <tr>
          <td>${booking.movie.title}</td>
          <td>
            On ${booking.show.showDate} from ${booking.show.showTimeStart}
            to ${booking.show.showTimeEnd}
          </td>
          <td>
              ${booking.theater.title}
          </td>
          <td>
              ${booking.seatNo}
          </td>
          <td>
            <a href="/profile/book/${booking.id}" class="btn btn-warning">Print</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jsbarcode@3.8.0/dist/JsBarcode.all.min.js"></script>
<script>
  JsBarcode(".barcode").init();
</script>
</body>
</html>
