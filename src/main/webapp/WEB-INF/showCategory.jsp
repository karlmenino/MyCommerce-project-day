<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Details</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<c:if test="${ERROR_TYPE_ID_CATEG}">
    <p>product id must be an integer</p>
</c:if>

<c:if test="${ERROR_UNKNOWN_CATEG}">
    <p>Product does not exist</p>
</c:if>

<c:if test="${not empty category}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Desrciption</th>
        </tr>
        </thead>
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
        </tr>
    </table>
</c:if>

<jsp:include page="footer.jsp"></jsp:include>

</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>
