<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add user</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Add product</h1>
<form action="/add-user" method="post">
    <label for="firstname">firstname</label>
    <input id="firstname" type="text" name="firstname">
    <label for="lastname">lastname</label>
    <input id="lastname" type="text" name="lastname">
    <label for="login">login</label>
    <input id="login" type="text" name="login">
    <label for="password">password</label>
    <input id="password" type="text" name="password">
    <button type="submit">Add</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>
