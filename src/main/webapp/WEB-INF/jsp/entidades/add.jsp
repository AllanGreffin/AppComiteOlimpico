<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Index Page</title>
    </head>
    <body>
 <div class="container">
  <h1>Criação de Entidade</h1>
  <div class="card">
   <div class="card-body">
    <form action="/Entidades/success" method="post">

     <div class="form-group row">
      <label for="nome" class="col-sm-2 col-form-label">Nome:</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="nome"
        placeholder="Entre com o nome da entidade">
      </div>
     </div>

     <div class="form-group row">
      <label for="continente" class="col-sm-2 col-form-label">Continente</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="continente"
        placeholder="Continente da entidade">
      </div>
     </div>

     <div class=" form-group row">
      <label for="populacao" class="col-sm-2 col-form-label">População</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="populacao" placeholder="Entre com a população do continente">
      </div>
     </div>

     <button type="submit" class="btn btn-primary">Submit</button>
    </form>
   </div>
  </div>
 </div>
</body>
</html>

