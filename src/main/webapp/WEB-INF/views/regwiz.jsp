<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/MainStyle.css" />" rel="stylesheet">
    <title>Registration</title>
    <style type="text/css">
        body {
            margin: 0;
        }
    </style>
</head>
<body>
<div id="Background">
    <div id="Empty"></div>
    <div id="Container">
        <form action="/OctoberCountry/reg" method="post">
            <input type="text" name="login" placeholder="Login" autocomplete="off">
            <input type="password" name="password" placeholder="Password" autocomplete="off">
            <input type="text" name="firstname" placeholder="First name" autocomplete="off">
            <input type="text" name="secondname" placeholder="Second name" autocomplete="off">
            <input type="text" name="email" placeholder="Email" autocomplete="off">
            <input type="text" name="phone" placeholder="Phone" autocomplete="off">
            <input type="submit" name="action" value="Register">
            <input type="submit" name="action" value="Cancel">
        </form>
    </div>
</div>
</body>
</html>