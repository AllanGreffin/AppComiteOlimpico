<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Comit? Ol?mpico</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">	
		
                <a href="/surfes/cadastro">Novo surfista</a>

                <hr>
            
		<c:if test="${not empty nome}">
			<div class="alert alert-success">
				 <strong>Confirma??o!</strong> Usu?rio ${nome} cadastrado com sucesso!!!
			</div>
		</c:if>
		
		<c:if test="${not empty lista}">
		
			<h4>Listagem de Surfistas (${lista.size()}):</h4>		
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Nome</th>
			        <th>Sexo</th>
			        <th>Nascimento</th>
			        <th>Comissao</th>
			        <th>Ondas Gigantes</th>
                                <th>MarcaPrancha</th>
                                <th>Tamanho Bermuda</th>
			        <c:if test="${user.admin}">
			        	<th></th>
			        </c:if>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="a" items="${lista}">
				      <tr>
				      	<td>${a.id}</td>
				        <td>${a.nome}</td>
                                        <td>${a.sexo}</td>
                                        <td>${a.nascimento}</td>
                                        <td>${a.comissao.nome}</td>
                                        <td>${a.ondasGigantes}</td>
                                        <td>${a.marcaPrancha}</td>
                                        <td>${a.tamanhoBermuda}</td>
                                        <td><a href="/surfes/${a.id}/excluir">
                                            Excluir
                                        </a>
                                        </td>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>
	  	</c:if>
	  			
	  	<c:if test="${empty lista}">
	  		<h4>N?o existem surfistas cadastrados!</h4>
	  	</c:if>
	</div>
</body>
</html>