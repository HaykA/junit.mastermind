<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="bugs" uri="http://howest.be/bugs/core"%>
<%@taglib prefix="mm" uri="http://howest.be/bugs/mastermind"%>

<bugs:head title="Homepage" bodyId="homepage"/>
<bugs:header active="home"/>

<div class="wrapper container">

  <form action="<c:url value='/mastermind'/>" method="post" class="scheme-selector" id="scheme-selector">
    <div class="row">
    <c:forEach items="${schemes}" var="scheme">
    <mm:scheme scheme="${scheme}"/>
    </c:forEach>
      </div>
    <input type="hidden" id="schemeId" name="schemeId"/>
  </form> 
</div>

<bugs:tail/>
 