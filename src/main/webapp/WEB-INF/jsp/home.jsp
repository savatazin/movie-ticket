<%@include file="helpers/header.jsp" %>

<div class="container">
  <div class="row">
    <%@include file="helpers/carousel.jsp" %>
  </div>
</div>

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

<%@include file="helpers/footer.jsp" %>