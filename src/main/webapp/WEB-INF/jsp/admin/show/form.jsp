<%@include file="../../helpers/header.jsp" %>

<div class="container">
  <div class="row">
    <span class="label label-alert">${errorMessage}</span>
    <form action="${formAction}" method="post" name="showForm">
      <div class="form-group">
        <label for="movieId">Movie</label>
        <div>
          <select id="movieId" name="movieId" class="movie-select" style="width: 25%" required>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="theaterId">Theater</label>
        <div>
          <select id="theaterId" name="theaterId" class="theater-select" style="width: 25%"
                  required>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="showDate">Show Date</label>
        <input id="showDate" type="text" name="showDate" class="date-picker" required>
      </div>
      <div class="form-group">
        <label for="showTimeStart">Show Time Start</label>
        <input id="showTimeStart" type="text" name="showTimeStart" class="time-picker"
               required>
      </div>
      <div class="form-group">
        <label for="showTimeEnd">Show Time End</label>
        <input id="showTimeEnd" type="text" name="showTimeEnd" class="time-picker" required>
      </div>
      <button type="submit" class="btn btn-success btn-block">Save</button>
    </form>
  </div>
</div>

<%@include file="../../helpers/footer.jsp" %>