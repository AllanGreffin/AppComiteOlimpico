<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<!--private String Nome;
    private String Continente;
    private long Populacao;
    private Comissao Comissao;-->
        
	<div class="container">	
            <form action="/bebida/incluir" method="post">	
                <div class="form-group">
                    <label>Nome:</label>
                    <input value="" type="text" class="form-control" placeholder="Entre com o nome da entidade" name="nome">
                </div>	
                
                <div class="form-group">
                    <label>Continente:</label>
                    <input value="" type="text" class="form-control" placeholder="Entre com o nome do continente" name="continente">
                </div>		
                
                <div class="form-group">
                    <label>População</label>
                    <input value="" type="number" class="form-control" placeholder="Entre com o quantitativo populacional" name="populacao">
                </div>		

                    <button class="btn btn-primary" type="submit">Cadastrar</button>
            </form>
	</div>
</body>
</html>