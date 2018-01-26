<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.jsp" %>

<div class="container">
  <div class="row">
    <h1>Theaters</h1>
    <div class="text-right">
      <a href="/admin/theater/new" class="btn btn-success" aria-label="Left Align">
        Add New Theater</a>
    </div>
    <table class="table table-striped table-hover">
      <thead>
      <tr>
        <th>Title</th>
        <th>Capacity</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${theaters}" var="theater">
        <tr>
          <td>${theater.title}</td>
          <td>${theater.capacity}</td>
          <td>
            <a href="/admin/theater/${theater.id}/edit">
              <span class="glyphicon glyphicon-edit"></span>
            </a>
            <a href="/admin/theater/${theater.id}/delete">
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