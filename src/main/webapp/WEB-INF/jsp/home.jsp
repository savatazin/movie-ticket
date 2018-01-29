<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html class="no-js" lang="">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Movie</title>
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
    <ul class="movie-list">
      <c:forEach items="${movies}" var="movie">
        <li>
          <a href="/movie/${movie.id}/${fn:replace(fn:toLowerCase(movie.title) ," ", "-")}">
            <img src="${movie.posterImgUrl}" alt="${movie.title}" height="300" width="190"
                 class="img-thumbnail">
            <p class="movie-title">${movie.title}</p>
          </a>
        </li>
      </c:forEach>
    </ul>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
