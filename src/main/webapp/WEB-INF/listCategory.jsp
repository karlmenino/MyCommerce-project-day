<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Category list</h1>


<c:if test="${empty categorylist}">
    <p>no product yet.</p>
    <a href="/auth/add-category">Add product</a>
</c:if>

<table>
    <c:forEach items="${categorylist}" var="product">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getDescription()}</td>
            <td><a href="/category-details?id=${product.getId()}">Details</a></td>
            <c:choose>
                <c:when test="${sessionScope.user.isAdmin()}">
                    <td>
                        <form action="/auth/removeCategory" method="post">
                            <input hidden name="productId" value="${product.getId()}">
                            <button type="submit">Remove</button>
                        </form>
                    </td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</html>
