<%@include file="helpers/header.jsp" %>

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

<%@include file="helpers/footer.jsp" %>