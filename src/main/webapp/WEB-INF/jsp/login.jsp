<%@include file="helpers/header.jsp" %>

<div class="container">
  <form action="/login" method="post" class="form-signin">
    <h3 class="form-signin-heading">Welcome</h3>
    <br/>
    <input type="text" id="email" name="email" placeholder="Email"
           class="form-control"/> <br/>
    <input type="password" placeholder="Password"
           id="password" name="password" class="form-control"/> <br/>

    <%--<div align="center">--%>
    <%--<p style="font-size: 20; color: #FF1C19;">Email or Password invalid, please verify</p>--%>
    <%--</div>--%>
    <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">
      Login
    </button>
  </form>
</div>

<%@include file="helpers/footer.jsp" %>