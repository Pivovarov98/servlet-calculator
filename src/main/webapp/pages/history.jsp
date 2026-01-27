<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>History</title>
</head>
<body>
<jsp:include page="/fragments/_header.jsp"/>

<div class="container">
    <c:if test="${alert != null}">
        <div class="alert alert-warning" role="alert">
                ${alert}
        </div>
    </c:if>
    <c:if test="${history != null}">
        <c:forEach items="${history}" var="exp">
            <div class="row justify-content-center">
                <div class="col-3">
                    <div class="card">
                        <div class="card-body">
                            <p class="card-text">${exp}</p>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
