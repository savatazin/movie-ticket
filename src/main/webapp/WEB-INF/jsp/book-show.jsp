<%@include file="helpers/header.jsp" %>

<div class="container">
  <div class="row">
    <%@include file="helpers/ticket.jsp" %>
  </div>
</div>

<h2>${show}</h2>

<form action="/book/${booking.show.id}/${booking.seatNo}/purchase" method="post" name="bookForm"
      class="text-center">
  <button type="submit" class="btn btn-success btn-lg">Purchase</button>
</form>

<%@include file="helpers/footer.jsp" %>