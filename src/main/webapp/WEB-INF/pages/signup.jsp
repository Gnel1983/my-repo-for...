<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Signup here!</h1>

<form:form  method="post"  >
    Username:<form:input path="username"/>
    <br/>
    password:<form:input path="password"/>
    <br/>
    <input type="submit" value="signup">
</form:form>
</body>
</html>
