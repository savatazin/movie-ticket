<%@include file="../../helpers/header.jsp" %>

<div class="container">
  <div class="row">
    <span class="label label-alert">${errorMessage}</span>
    <form action="${movieFormAction}" method="post" name="movieForm">
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" placeholder="Title" name="title"
               value="${theater.title}" required>
      </div>

      <div class="form-group">
        <label for="imdbUrl">IMDB Url</label>
        <input type="text" class="form-control" id="imdbUrl" placeholder="IMDB Url"
               name="imdbUrl"
               value="${theater.imdbUrl}" required>
      </div>

      <div class="form-group">
        <label>Poster Image</label>
        <div>
          <label for="posterImgUrl">
            <img src="https://www.equusbook.com/images/crop-placeholder.jpg"
                 class="img-rounded" height="125">
          </label>
        </div>
        <input type="text" name="posterImgUrl" value="${theater.posterImgUrl}" hidden="hidden" required>
      </div>

      <div class="form-group">
        <label>Banner Image</label>
        <div>
          <label for="bannerImgUrl">
            <img src="https://www.equusbook.com/images/crop-placeholder.jpg"
                 class="img-rounded" height="125">
          </label>
        </div>
        <input type="text" name="bannerImgUrl" value="${theater.bannerImgUrl}" hidden="hidden" required>
      </div>

      <button type="submit" class="btn btn-success btn-block">Save</button>
    </form>
  </div>
</div>

<input type="file" name="posterImg" id="posterImgUrl" style="display: none;">
<input type="file" name="bannerImg" id="bannerImgUrl" style="display: none;">


<%@include file="../../helpers/footer.jsp" %>