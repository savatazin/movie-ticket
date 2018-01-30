<%@include file="helpers/header.jsp" %>

<div class="container">
  <form autocomplete="off" action="/registration" method="post" class="form-signin" role="form"
        name="userForm">
    <h2 class="form-signin-heading">Registration Form</h2>

    <input type="text" name="name" placeholder="First Name" class="form-control"
           required/> <br>

    <input type="text" placeholder="Last Name" name="lastName" class="form-control"
           required/><br>

    <input type="email" placeholder="Email" name="email" class="form-control"
           required/><br>

    <input type="password" name="password" placeholder="Password" class="form-control"
           required/><br>

    <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Register User"
            type="Submit">
      Register User
    </button>
    <br>

    <span class="label label-success">${successMessage}</span>

  </form>
</div>

<%@include file="helpers/footer.jsp" %>