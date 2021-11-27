<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Index Page</title>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu.jsp"/>
        
        <div class="container">
            Houve um problema com o login deste usuário. Tente novamente.
            <a class="btn btn-primary" href="/">Voltar</a>
        </div>
    </body>
</html>

