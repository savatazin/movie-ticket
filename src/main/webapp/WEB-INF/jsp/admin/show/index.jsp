<%@include file="../header.jsp" %>

<div class="container">
  <div class="row">
    <h1>Shows</h1>
    <div class="text-right">
      <a href="/admin/show/new" class="btn btn-success" aria-label="Left Align">
        Add New Show</a>
    </div>
    <table class="table table-striped table-hover">
      <thead>
      <tr>
        <th>Movie</th>
        <th>Theater</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${shows}" var="show">
        <tr>
          <td>
            <img src="${show.movie.bannerUrl}">
            <h3>${show.movie.title}</h3>
          </td>
          <td>${show.theater.title} (${show.theater.capacity})</td>
          <td>
            <a href="/admin/theater/${show.id}/edit">
              <span class="glyphicon glyphicon-edit"></span>
            </a>
            <a href="/admin/theater/${show.id}/delete">
              <span class="glyphicon glyphicon-remove"></span>
            </a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<%@include file="../footer.jsp" %>