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
    <div class="col-md-6 text-center">
      <h2>${movie.title}</h2>
      <img src="${movie.posterImgUrl}" alt="${movie.title}" width="300">
      <br/>
      <a href="${movie.imdbUrl}" class="btn btn-primary" target="_blank">View Movie
        Details</a>
    </div>
    <div class="col-md-6">
      <h3>Show Times</h3>
      <table class="table table-striped table-hover">
        <thead>
        <tr>
          <th>Date</th>
          <th>time</th>
          <th>Book Now</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${shows}" var="show">
          <tr>
            <td>${show.showDate}</td>
            <td>${show.showTimeStart} - ${show.showTimeEnd}</td>
            <td>
              <a href="/book/${show.id}" class="btn btn-danger">Buy Tickets</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
