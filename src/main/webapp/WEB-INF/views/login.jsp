<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/MainStyle.css" />" rel="stylesheet">
    <title>Log In</title>
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
        <div id="Hello">
        </div>
        <div id="Input">
            <form action="/OctoberCountry/auth" method="post">
                <input type="text" name="login" value="Username"><br>
                <input type="password" name="password" value="password"><br>
                <input type="submit" name="action" value="Log In" >
                <input type="submit" name="action" value="Register" >
            </form>

            <%
                String error = (String) request.getAttribute("error");
                if (error==null){
                    error = "";
                }

            %>

            <%=error%>

        </div>
    </div>
</div>


</body>
</html>
