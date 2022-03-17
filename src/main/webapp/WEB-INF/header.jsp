<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">E-commerce</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/list-product">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/list-category">Category</a>
                </li>
                <c:choose>
                <c:when test="${empty sessionScope.user}">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/add-user">s'inscricre</a>
                </li>
                </c:when>
                <c:when test="${sessionScope.user.isAdmin()}">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/auth/add-product">Add product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/auth/add-category">Add category</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/auth/basic-insert">Basic Insert</a>
                </li>
                </c:when>
                </c:choose>
                <c:choose>
                <c:when test="${not empty sessionScope.user}">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/auth/add-panier">Panier</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/logout">Logout</a>
                </li>
                </c:when>
                </c:choose>
                </li>
        </div>
    </div>
</nav>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
