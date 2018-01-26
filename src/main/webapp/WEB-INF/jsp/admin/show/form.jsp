<%@include file="../header.jsp" %>

<div class="container">
  <div class="row">
    <span class="label label-alert">${errorMessage}</span>
    <form action="${formAction}" method="post" name="showForm">
      <div class="form-group">
        <label for="movieId">Movie</label>
        <div>
          <select id="movieId" name="movieId" class="movie-select" style="width: 25%">
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="theaterId">Theater</label>
        <div>
          <select id="theaterId" name="theaterId" class="theater-select" style="width: 25%">
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="showDate">Show Date</label>
        <input id="showDate" type="text" name="showDate" class="date-picker">
      </div>
      <div class="form-group">
        <label for="showTimeStart">Show Time Start</label>
        <input id="showTimeStart" type="text" name="showTimeStart" class="time-picker">
      </div>
      <div class="form-group">
        <label for="showTimeEnd">Show Time End</label>
        <input id="showTimeEnd" type="text" name="showTimeEnd" class="time-picker">
      </div>
      <button type="submit" class="btn btn-default">Save</button>
    </form>
  </div>
</div>

<%@include file="../footer.jsp" %>