<%@include file="../../helpers/header.jsp" %>

<div class="container">
  <div class="row">
    <span class="label label-alert">${errorMessage}</span>
    <form action="${formAction}" method="post" name="theaterForm">
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" placeholder="Title" name="title"
               value="${theater.title}" required>
      </div>
      <div class="form-group">
        <label for="capacity">Capacity</label>
        <input type="text" class="form-control" id="capacity" placeholder="Capacity"
               name="capacity"
               value="${theater.capacity}" required>
      </div>
      <button type="submit" class="btn btn-success btn-block">Save</button>
    </form>
  </div>
</div>

<%@include file="../../helpers/footer.jsp" %>