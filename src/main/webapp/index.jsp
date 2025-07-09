<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Trekking World</title>
    <link rel="stylesheet" href="styles/style.css"/>
</head>
<body>
    <nav>
        <a href="home">Home</a> |
        <a href="about.jsp">About</a> |
        <a href="contact.jsp">Contact</a>
	<a href="register.jsp">Register</a>
    </nav>
    <h1>Explore the Adventure of Trekking</h1>
    <img src="<c:out value='${selectedImage}'/>" alt="Trekking" />
</body>
</html>
