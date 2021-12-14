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
                                <th>Comissão</th>
			        <c:if test="${user.admin}">
			        	<th></th>
			        </c:if>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="e" items="${lista}">
				      <tr>
				      	<td>${e.id}</td>
				        <td>${e.nome}</td>
                                        <td>${e.continente}</td>
                                        <td>${e.populacao}</td>
                                        <td>${e.comissao.nome}</td>
				        <c:if test="${user.admin}">
                                            <td><a href="/entidades/${e.id}/excluir">
                                                <%--<c:choose>--%>
                                                        <%--<c:when test = "${user.id != e.id}">--%>
                                                        Excluir
                                                        <%--</c:when>--%>
                                                <%--</c:choose>--%>
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