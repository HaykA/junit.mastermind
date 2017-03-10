<%@tag language="java" description="header" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name='active' required='false' type='java.lang.String'%>
<%@attribute name='user' required='false' type='be.howest.security.entities.User'%>

<header class="navheader navheader-fixed">
  <nav class="navmain navmain-default">
    <ul>
      <%-- Brand --%>
      <li class="brand">
        <a href="<c:url value='/'/>"><i class="fa fa-bug"></i></a>
      </li>
          
      <%-- Home --%>
      <c:set var="menuItemHome" value='<i class="fa fa-fw fa-home"></i> Home'/>
      <c:choose>
      <c:when test='${active eq "home"}'>
      <li class="active">${menuItemHome}</li>      
      </c:when>
      <c:otherwise>
      <li><a href="<c:url value='/'/>">${menuItemHome}</a></li>
      </c:otherwise>
      </c:choose>
      <%-- End Home --%>
      
      <%-- Home --%>
      <c:set var="menuItemGames" value='<i class="fa fa-fw fa-gamepad"></i> Games'/>
      <c:choose>
      <c:when test='${active eq "games"}'>
      <li class="active">${menuItemGames}</li>      
      </c:when>
      <c:otherwise>
      <li><a href="<c:url value='/games'/>">${menuItemGames}</a></li>
      </c:otherwise>
      </c:choose>
      <%-- End Home --%>

      <%-- LCD --%>
      <li>
        <ul class="navmain-lcd">
            <li class="lcd-bigbugs"><i class="fa fa-fw fa-bug"></i> 1</li>
            <li class="lcd-bugs"><i class="fa fa-fw fa-bug"></i> 273</li>
            <li class="lcd-gift"><i class="fa fa-fw fa-gift"></i> 3</li>
            <li class="lcd-eco"><i class="fa fa-fw fa-leaf"></i> 34</li>
            <li class="lcd-heart"><i class="fa fa-fw fa-heart"></i> 2</li>
        </ul>
      </li>
      <%-- End LCD --%>
      
      <%-- Signing --%>
      <c:choose>
      <c:when test="${not empty user}">
      <li class="pull-right">${user.name}</li>
      <li class="pull-right">
        <form action="<c:url value='/auth'><c:param name='signout'/></c:url>" method="post">
          <button class="button button-success" type="submit"><i class="fa fa-fw fa-sign-out"></i> Sign Out</button>
        </form>
      </li>
      </c:when>
      <c:otherwise>
      <li class="pull-right"><a href="<c:url value='/auth'/>"><i class="fa fa-fw fa-sign-in"></i> Sign In</a></li>
      </c:otherwise>
      </c:choose>
      
      <%-- End Signing --%>
      
    </ul>  
  </nav>
</header>