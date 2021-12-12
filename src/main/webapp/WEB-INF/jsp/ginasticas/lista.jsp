<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Comit� Ol�mpico</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">	
				
		<c:if test="${not empty lista}">
		
			<h4>Listagem de ginastas (${lista.size()}):</h4>		
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Nome</th>
			        <th>Nascimento</th>
			        <th>Comissao</th>
			        <th>Clube</th>
			        <th>Especialidade</th>
                                <th>Tamanho Uniforme</th>
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
<!--                                        <td>${a.nascimento}</td>
                                        <td>${a.comissao.nome}</td>
                                        <td>${a.clube}</td>
                                        <td>${a.especialidade}</td>
                                        <td>${a.tamanhoUniforme}</td>-->
				        <c:if test="${user.admin}">
				        	<td><a href="/usuario/${a.id}/excluir">
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
	  		<h4>N�o existem ginastas cadastrados!</h4>
	  	</c:if>
	</div>
</body>
</html>