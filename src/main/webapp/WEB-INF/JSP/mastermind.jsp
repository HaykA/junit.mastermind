<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="bugs" uri="http://howest.be/bugs/core"%>

<bugs:head title="Homepage" bodyId="mastermind" />
<bugs:header active="games"/>

  <div class="wrapper container centered">
    <main>

      <%-- Looping through reverse sorted attempts --%>
      <c:forEach items="${masterMind.reverseSortedAttempts}" var="attempt" varStatus="current">
      <c:choose>
        
        <%-- Building CURRENT PAWN --%>
        <c:when test="${masterMind.totalAllowedAttempts - current.index - 1 == masterMind.currentAttemptIndex and not masterMind.gameOver}">
        <div class="pawn pawn-active row">
          <c:forEach begin="1" end="${masterMind.pawnCount}">
            <button data-color="0"><span></span></button>
          </c:forEach>
          <div class="feedback">
            <button>
            <c:set var="newRow" value='</div><div class="row">'/>
              <div class="row">
                <c:forEach begin="1" end="${masterMind.pawnCount}" varStatus="current">
                <div class="cell"></div>
              <c:if test="${current.index == (masterMind.pawnCount / 2 + masterMind.pawnCount % 2)}">
              ${newRow}
              </c:if>
                </c:forEach>
              </div>
            </button>
          </div>
        </div>
        </c:when>
        
        <%-- Building PREVIOUS ATTEMPTS (WITH COLORS) --%>
        <c:when test="${masterMind.totalAllowedAttempts - current.index - 1 < masterMind.currentAttemptIndex}">
          <div class="pawn pawn-history row">
            <c:forEach items="${attempt.colors}" var="color">
              <div data-color="${color}"><span></span></div>
            </c:forEach>
            <div class="feedback">
            <c:set var="newRow" value='</div><div class="row">'/>
              <div class="row">
                <c:forEach begin="1" end="${masterMind.pawnCount}" varStatus="current">
                
                  <c:choose>
                    <c:when test="${current.index <= attempt.feedback.totalFoundAtValidPosition}">
                      <c:set var="dataPos" value=' data-pos="valid"'/>
                    </c:when>
                    <c:when test="${current.index + attempt.feedback.totalFoundAtValidPosition
                        < attempt.feedback.totalFoundAtInvalidPosition}">
                      <c:set var="dataPos" value=' data-pos="invalid"'/>
                    </c:when>
                    <c:otherwise>
                      <c:set var="dataPos" value=' data-pos="empty"'/>
                    </c:otherwise>
                  </c:choose>
                  
                <div class="cell" ${dataPos}></div>
              <c:if test="${current.index == (masterMind.pawnCount / 2 + masterMind.pawnCount % 2)}">
              ${newRow}
              </c:if>
                </c:forEach>
              </div>
            </div>
          </div>
        </c:when>
        
        <%-- Building EMPTY PAWNS --%>
        <c:otherwise>
          <div class="pawn row">
            <c:forEach begin="1" end="${masterMind.pawnCount}">
              <div class="cell"></div>
            </c:forEach>
            <div class="feedback">
            <c:set var="newRow" value='</div><div class="row">'/>
              <div class="row">
                <c:forEach begin="1" end="${masterMind.pawnCount}" varStatus="current">
                <div class="cell"></div>
              <c:if test="${current.index == (masterMind.pawnCount / 2 + masterMind.pawnCount % 2)}">
              ${newRow}
              </c:if>
                </c:forEach>
              </div>
          </div>
          </div>
        </c:otherwise>
      </c:choose>
    </c:forEach> 
    <%-- END Looping through reverse sorted attempts --%>
    </main>
  </div>

<div class="property-bar"></div>

  <bugs:tail/>
 