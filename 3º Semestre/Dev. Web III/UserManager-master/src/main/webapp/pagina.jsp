<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Boolean isLoggedIn = (Boolean) session.getAttribute("is_logged_in");

    if( isLoggedIn == null || isLoggedIn == false){
        response.sendRedirect("http://localhost:8080/login/index.jsp");
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Bem vindo <%= session.getAttribute("user") %></h1>

    <a href="http://localhost:8080/login/login">sair</a>

</body>
</html>
