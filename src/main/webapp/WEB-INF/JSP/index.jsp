<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mc" uri="http://howest.be/mastermind/core"%>

<mc:head title="Homepage" bodyId="homepage"/>
<mc:header/>

<div class="wrapper container">

  <form action="<c:url value='/mastermind'/>" method="post" class="scheme-selector" id="scheme-selector">
    <div class="row">
    <c:forEach items="${schemes}" var="scheme">
    <mc:scheme scheme="${scheme}"/>
    </c:forEach>
      </div>
    <input type="hidden" id="schemeId" name="schemeId"/>
  </form> 
</div>

<mc:tail/>
 