<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Login Page</title>
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container">
		<h2>Sistema de Cadastramento de Alunos</h2>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-warning">
				 <strong>Alerta!</strong> ${msg}
			</div>
		</c:if>
		
		<form action="/login" method="post">
			<div class="form-group">
			  <label>Email:</label>
			  <input type="email" value="allan.greffin@al.edu.infnet.br" class="form-control" placeholder="Entre com o e-mail" name="email">
			</div>
			
			<div class="form-group">
			  <label>Senha:</label>
			  <input type="password" value="xxxxxxxxxxxxxxxx" class="form-control" placeholder="Entre com a senha" name="senha">
			</div>
			
			<button type="submit" class="btn btn-primary">Acessar</button>
		</form>
	</div>
    </body>
</html>

