<%@include file="helpers/header.jsp" %>

<div class="container">
  <div class="row">
    <%@include file="helpers/ticket.jsp" %>
  </div>
</div>

<form action="/book/${show.id}/${seatNo}/purchase" method="post" name="bookForm"
      class="text-center">
  <button type="submit" class="btn btn-success btn-lg">Purchase</button>
</form>

<%@include file="helpers/footer.jsp" %>