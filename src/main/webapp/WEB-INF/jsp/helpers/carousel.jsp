<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <div class="well">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <c:forEach items="${bannerMovies}" var="movie" varStatus="loop">
          <c:choose>
            <c:when test="${loop.index eq 0}">
              <li data-target="#carousel-example-generic" data-slide-to="${loop.index}"
                  class="active"></li>
            </c:when>
            <c:otherwise>
              <li data-target="#carousel-example-generic" data-slide-to="${loop.index}"></li>
            </c:otherwise>
          </c:choose>
        </c:forEach>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">

        <c:forEach items="${bannerMovies}" var="movie" varStatus="loop">
          <c:choose>
            <c:when test="${loop.index eq 0}">
              <div class="item active">
                <img src="${movie.bannerImgUrl}" width="1180" height="100">
              </div>
            </c:when>
            <c:otherwise>
              <div class="item">
                <img src="${movie.bannerImgUrl}" width="1180" height="100">
              </div>
            </c:otherwise>
          </c:choose>
        </c:forEach>
      </div>

      <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic" role="button"
         data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" role="button"
         data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
</div>