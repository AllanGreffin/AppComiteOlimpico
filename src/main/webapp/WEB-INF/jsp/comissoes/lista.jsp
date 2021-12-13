<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao"%>
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

        <a href="/comissoes/cadastro">Nova comissão</a>

        <hr>

        <c:if test="${not empty lista}">

                <h4>Listagem de usuários (${lista.size()}):</h4>		
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Entidade</th>
                        <th>Atletas</th>
                        <c:if test="${user.admin}">
                                <th></th>
                        </c:if>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${lista}">
                              <tr>
                                <td>${c.id}</td>
                                <td>${c.nome}</td>
                                <td>${c.entidade.nome}</td>
                                <td>${c.atletas.size()}</td>
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
                <h4>Não existem comissões cadastrados!</h4>
        </c:if>
    </div>
</body>
</html>