<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<!-- PAGINATION -->

<tilesx:useAttribute id="currentIndex" name="currentIndex" />
<tilesx:useAttribute id="beginIndex" name="beginIndex" />
<tilesx:useAttribute id="endIndex" name="endIndex" />
<tilesx:useAttribute id="totalPages" name="totalPages" />

<c:if test="${endIndex > 1}">
	<div class="pagination">
	    <ul class="pagination">
	        <c:choose>
	            <c:when test="${currentIndex == 1}">
	                <li class="disabled"><a href="#">&lt;&lt;</a></li>
	                <li class="disabled"><a href="#">&lt;</a></li>
	            </c:when>
	            <c:otherwise>
	                <li><a onclick="getPage(1);">&lt;&lt;</a></li>
	                <li><a onclick="getPage(${currentIndex - 1});">&lt;</a></li>
	            </c:otherwise>
	        </c:choose>
	        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
	            <c:url var="pageUrl" value="/pages/${i}" />
	            <c:choose>
	                <c:when test="${i == currentIndex}">
	                    <li class="active"><a onclick="getPage(${i});"><c:out value="${i}" /></a></li>
	                </c:when>
	                <c:otherwise>
	                    <li><a onclick="getPage(${i});"><c:out value="${i}" /></a></li>
	                </c:otherwise>
	            </c:choose>
	        </c:forEach>
	        <c:choose>
	            <c:when test="${currentIndex == totalPages}">
	                <li class="disabled"><a href="#">&gt;</a></li>
	                <li class="disabled"><a href="#">&gt;&gt;</a></li>
	            </c:when>
	            <c:otherwise>
	                <li><a onclick="getPage(${currentIndex + 1});">&gt;</a></li>
	                <li><a onclick="getPage(${totalPages});">&gt;&gt;</a></li>
	            </c:otherwise>
	        </c:choose>
	    </ul>
	</div>
</c:if>