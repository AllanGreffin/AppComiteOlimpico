<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Gestão de Pedidos</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp"/>

    <!--
    protected String Nome;
    protected boolean Sexo; //true = 1 = homem, false = 0 = mulher
    protected LocalDateTime Nascimento;
    protected Comissao comissao;
    private boolean OndasGigantes;
    private String MarcaPrancha;
    private int TamanhoBermuda;-->
        
    <div class="container">	
        <form action="/surfes/incluir" method="post">	
            <div class="form-group">
              <label>Nome:</label>
              <input value="" type="text" class="form-control" placeholder="Entre com o nome do ginasta" name="nome">
            </div>			

            <div class="form-group">
                <label>Sexo</label>
                <div class="form-check-inline">
                  <label class="form-check-label">
                    <input type="checkbox" name="sexo" class="form-check-input"> Do sexo masculino?
                  </label>
                </div>			
            </div>

            <div class="form-group">
              <label>Nascimento (Digite no formato dd/MM/yyyy)</label>
              <input value="" type="text" class="form-control" placeholder="" name="dataDeNascimento">
            </div>

            <div class="form-group">
                <label>Compete em ondas gigantes?</label>
                <div class="form-check-inline">
                  <label class="form-check-label">
                    <input type="checkbox" name="ondasGigantes" class="form-check-input">Sim, compete
                  </label>
                </div>			
            </div>

            <div class="form-group">
              <label>Marca da prancha</label>
              <input value="" type="text" class="form-control" placeholder="" name="marcaPrancha">
            </div>
            
            <div class="form-group">
              <label>Tamanho da bermuda</label>
              <input value="" type="number" class="form-control" placeholder="" name="tamanhoBermuda">
            </div>

            <select path="comissao" name="comissaoId">
                <c:forEach items="${comissoes}" var="c">
                   <option value="${c.id}">${c.nome} 
                   </option>
                </c:forEach>
            </select>
            
            <c:if test="${comissoes.size() > 0}">
                   <button class="btn btn-primary" type="submit">Cadastrar</button>
            </c:if>
            
            <c:if test="${comissoes.size() == 0}">
                   Necessário criar uma comissão para conseguir adicionar um atleta
            </c:if>  
        </form>
    </div>
</body>
</html>