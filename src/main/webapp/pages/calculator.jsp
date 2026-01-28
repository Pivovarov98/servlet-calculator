<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Calculator</title>
</head>
<body>
<jsp:include page="/fragments/_header.jsp"/>

<div class="container">
<c:if test="${alert != null}">
        <div class="alert alert-warning" role="alert">
                ${alert}
        </div>
    </c:if>
    <div class="row justify-content-center">
        <div class="col-3">
            <form action="/calculator" method="post">
                <div class="mb-3">
                    <label for="exampleInputText" class="form-label">Expression</label>
                    <c:choose>
                        <c:when test="${result != null}">
                            <input type="text" name="expression" class="form-control" value="${result}">
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="expression" class="form-control">
                        </c:otherwise>
                    </c:choose>
                </div>
                <button type="submit" class="btn btn-primary w-100">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
