<%@include file="../header.jsp" %>

<div class="container">
  <div class="row">
    <span class="label label-alert">${errorMessage}</span>
    <form action="${formAction}" method="post" name="theaterForm">
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" placeholder="Title" name="title"
               value="${theater.title}">
      </div>
      <div class="form-group">
        <label for="capacity">Capacity</label>
        <input type="text" class="form-control" id="capacity" placeholder="Capacity" name="capacity"
               value="${theater.capacity}">
      </div>
      <button type="submit" class="btn btn-default">Save</button>
    </form>
  </div>
</div>

<%@include file="../footer.jsp" %>