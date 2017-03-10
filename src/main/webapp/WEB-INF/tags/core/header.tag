<%@tag language="java" description="header" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name='active' required='false' type='java.lang.String'%>
<%@attribute name='user' required='false' type='be.howest.security.entities.User'%>

<header class="navheader navheader-fixed">
  <nav class="navmain navmain-default">
    <ul>
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
      
      <%-- Signing --%>
      
      <c:choose>
      <c:when test="${not empty user}">
      <li>${user.name}</li>
      <li>  
        <form action="<c:url value='/auth'><c:param name='signout'/></c:url>" method="post">
          <button class="button button-success" type="submit"><i class="fa fa-fw fa-sign-out"></i> Sign Out</button>
        </form>
      </li>
      </c:when>
      <c:otherwise>
      <li><a href="<c:url value='/auth'/>"><i class="fa fa-fw fa-sign-in"></i> Sign In</a></li>
      </c:otherwise>
      </c:choose>
      
      <%-- End Signing --%>
      
    </ul>  
  </nav>
</header>