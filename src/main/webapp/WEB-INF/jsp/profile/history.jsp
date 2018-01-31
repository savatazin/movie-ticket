<%@include file="../helpers/header.jsp" %>

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
            <a href="/profile/book/${booking.id}" class="btn btn-warning" target="_blank">Print</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>
</div>

<%@include file="../helpers/footer.jsp" %>