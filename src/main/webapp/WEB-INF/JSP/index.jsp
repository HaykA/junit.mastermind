<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/assets/css/reset.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/screen.css'/>">
<title>MasterMind Test</title>
</head>
<body>
  <div class="container centered">
    <main id="mastermind">
      <c:forEach items="${masterMind.reverseSortedAttempts}" var="attempt" varStatus="loopAttempts">
      <c:choose>
        <c:when
          test="${masterMind.totalAllowedAttempts - loopAttempts.index - 1 == masterMind.currentAttemptIndex and not masterMind.gameOver}">

          <div class="pawn pawn-active">
            <c:forEach items="${attempt}" var="color" varStatus="loopAttempt">
              <button data-color="${color}"><span></span></button>
            </c:forEach>
            <div class="feedback">Feedback</div>
          </div>

        </c:when>
        
        <c:when
          test="${masterMind.totalAllowedAttempts - loopAttempts.index - 1 < masterMind.currentAttemptIndex}">

          <div class="pawn pawn-history">
            <c:forEach items="${attempt}" var="color" varStatus="loopAttempt">
              <div data-color="${color}"><span></span></div>
            </c:forEach>
            <div class="feedback">Feedback</div>
          </div>

        </c:when>
        
        <c:otherwise>
          <div class="pawn">
            <c:forEach begin="1" end="${masterMind.pawnCount}">
              <div class="cell"></div>
            </c:forEach>
            <div class="feedback">Feedback</div>
          </div>

        </c:otherwise>
      </c:choose>

    </c:forEach> </main>
  </div>
</body>
</html>