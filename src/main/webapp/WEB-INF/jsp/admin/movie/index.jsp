<%@include file="../../helpers/header.jsp" %>

<div class="container">
  <div class="row">

    <h2>Movies</h2>
    <div class="text-right">
      <a href="/admin/movie/new" class="btn btn-success">Add New Movie</a>
    </div>

    <ul class="movie-list">
      <c:forEach items="${movies}" var="movie">
        <li>
            <img class="banner-img" src="${movie.posterImgUrl}" width="213" height="300">
            <h3>${movie.title}</h3>
            <a href="/admin/movie/${movie.id}/delete" class="btn btn-danger btn-block">Delete</a>
        </li>
      </c:forEach>
    </ul>

  </div>
</div>

<%@include file="../../helpers/footer.jsp" %>