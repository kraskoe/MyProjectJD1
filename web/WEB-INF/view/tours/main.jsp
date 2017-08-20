<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    Туры
    <div class="productTable">
        <c:forEach var="country" items="${countries}" varStatus="status">
            <div id="${country.id}">${country.name}</div>
        </c:forEach>
    </div>
</div>




