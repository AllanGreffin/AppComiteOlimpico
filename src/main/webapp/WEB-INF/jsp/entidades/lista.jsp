<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Comitê Olímpico</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">	
		
                <a href="/entidades/cadastro">Nova Entidade</a>

                <hr>
            
		<c:if test="${not empty nome}">
			<div class="alert alert-success">
				 <strong>Confirmação!</strong> Usuário ${nome} cadastrado com sucesso!!!
			</div>
		</c:if>
		
		<c:if test="${not empty lista}">
		
			<h4>Listagem de usuários (${lista.size()}):</h4>		
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Nome</th>
			        <th>Continente</th>
			        <th>População</th>
			        <c:if test="${user.admin}">
			        	<th></th>
			        </c:if>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="u" items="${lista}">
				      <tr>
				      	<td>${u.id}</td>
				        <td>${u.nome}</td>
                                        <td>${u.continente}</td>
                                        <td>${u.populacao}</td>
				        <c:if test="${user.admin}">
				        	<td><a href="/usuario/${u.id}/excluir">
							<c:choose>
								<c:when test = "${user.id != u.id}">
								Excluir
								</c:when>
							</c:choose>
				        	</a>
				        	</td>
				        	
				        </c:if>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>
	  	</c:if>
	  			
	  	<c:if test="${empty lista}">
	  		<h4>Não existem entidades cadastrados!</h4>
	  	</c:if>
	</div>
</body>
</html>