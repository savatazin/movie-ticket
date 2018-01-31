<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal"/>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
              data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand logo" href="/">TnA Theaters</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

      <c:if test="${!empty user and user ne 'anonymousUser' and fn:contains(user.authorities, 'ADMIN')}">
        <ul class="nav navbar-nav">
          <li><a href="/admin/theater">Theaters</a></li>
          <li><a href="/admin/movie">Movies</a></li>
          <li><a href="/admin/show">Shows</a></li>
        </ul>
      </c:if>


      <ul class="nav navbar-nav navbar-right">

        <sec:authorize access="!isAuthenticated()">
          <li><a href="/login">Log In</a></li>
          <li><a href="/registration">Register</a></li>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">
              <span class="glyphicon glyphicon-cog"></span>
              <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="/profile/history">History</a></li>
              <li><a href="/logout">Log Out</a></li>
            </ul>
          </li>
        </sec:authorize>
      </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>