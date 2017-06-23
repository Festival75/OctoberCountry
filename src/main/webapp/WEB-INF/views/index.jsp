<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/MainStyle.css" />" rel="stylesheet">
    <title>October Country</title>
    <style type="text/css">
        body {
            margin: 0;
        }
    </style>
</head>
<body>

<%
    String name = (String) session.getAttribute("login");
    if (name == null) {
        name = "";
    }
%>
<div id="Background">
    <h2>Hello <%=name%>!</h2>
</div>
</body>
</html>
