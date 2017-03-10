<%@tag language="java" description="scheme" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name='scheme' required='true' type='be.howest.entities.Scheme'%>

<c:set var="fullStars" value="${scheme.difficultyRate / 2}"/>
<c:set var="halfStars" value="${scheme.difficultyRate % 2}"/>
<c:set var="emptyStars" value="${5 - fullStars - halfStars}"/>

<c:choose>
  <c:when test="${scheme.difficultyRate == 0}">
    <c:set var="bugs" value="Unrated"/>  
  </c:when>
  <c:otherwise>
    <c:set var="bugs" value='<i class="fa fa-bug get-bugs"></i> ${scheme.difficultyRate * 3}'/>  
  </c:otherwise>
</c:choose>

<div class="scheme" data-scheme="${scheme.id}">
  <table>
    <tbody>
      <tr>
        <th>Pawns</th>
        <td>${scheme.pawnCount}</td>
        <td rowspan="2" class="scheme-rating">
          <small>
          
          <c:forEach begin="1" end="${fullStars}">
            <i class="fa fa-star"></i>
          </c:forEach>
          
          <c:forEach begin="1" end="${halfStars}">
            <i class="fa fa-star-half-o"></i>
          </c:forEach>
          
          <c:forEach begin="1" end="${emptyStars + 0.5}">
            <i class="fa fa-star-o"></i>
          </c:forEach>
  
          </small>
        
        ${bugs}
        
        </td>
        <td rowspan="2" class="scheme-go"><i class="fa fa-chevron-right"></i></td>
      </tr>
      <tr>
        <th>Colors</th>
        <td>${scheme.colorCount}</td>
      </tr>
    </tbody>
  </table>
</div>