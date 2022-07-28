
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar cliente</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="css/letra.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo-actualizar-cliente.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo-logo.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <section class="container">
            <header class="fila">
                <center><img src="img/logo-login.PNG" width="200" height="200" ></center>
        <br>
            </header> 
        </section> 
        <%@include file="include/menubar.jsp"%>
        <br> 
        <br> 
        <br>  
        <br>
        <h1 class="letra" align="center">Agregar cliente</h1>
        <br>  
        <br>
        <div class="d-flex">
            <div class="col-sm-6">
                <form style="margin: auto; display: table" action="Cliente" method="post"
                      style="margin: auto; display: table; width: 500px;"> 
                    <input type="hidden" name="accion" value="INS"/>
                    <form class="form form-control">
                        <div class="">
                            <label>Nombre</label>
                        <br>
                            <input class="form-control" type="text" name="txtNombre" style="width: 650px"
                                   value="${cliente.nombre}" placeholder="Ingrese el nombres" required/>
                        </div> <br><br>
                        <div class="">
                            <label>Apellido</label>
                        <br>
                            <input  class="form-control" type="text" name="txtApellido" style="width: 650px"
                                    value="${cliente.apellido}" placeholder="Ingrese el apellidos" required/>
                        </div> <br><br>
                        <div class="">
                            <label>Correo</label>
                        <br>
                            <input  class="form-control" class="form-control" type="email" style="width: 650px"
                                    value="${cliente.correo}" name="txtCorreo" placeholder="Ingrese el correo electrónico" required  />
                        </div> <br><br>
                        <div class="">
                            <label>Telefono</label>
                        <br>
                            <input  class="form-control" type="number" style="width: 650px"
                                    value="${cliente.telefono}" name="txtTelefono" placeholder="Ingrese el número telefónico" required/>
                        </div> <br><br>
                        <div class="">
                            <label>Documento</label>
                        <br>
                            <input  class="form-control" type="number" style="width: 650px"
                                    value="${cliente.documento}" name="txtDocumento" placeholder="Ingrese el documento" required/>
                        </div> <br>
                        
                        <div class="">
                            <label>Usuario</label>
                        <br>
                            <input  class="form-control" type="text" style="width: 650px"
                                    value="${cliente.usuario}" name="txtUsu" placeholder="Ingrese el usuario" required/>
                        </div>
                        <br>
                        <div class="">
                            <label>Contraseña</label>
                        <br>
                            <input  class="form-control" type="password" style="width: 650px"
                                    value="${cliente.password}" name="txtContra" placeholder="Ingrese la contraseña" required/>
                        </div>
                        <br>
                        <div class="">
                            <label>Dirección</label>
                        <br>
                            <input  class="form-control" type="text" style="width: 650px"
                                    value="${cliente.direccion}" name="txtdireccion" placeholder="Ingrese la contraseña" required/>
                        </div>
                        <br>
                        <div class="">
                            <label>Estado</label>
                        <br>
                            <input  class="form-control" type="number" style="width: 650px"
                                    value="1" name="txtEstado" required readonly/>
                        </div>
                        
                        <br/> 
                        <br/><p style="text-align: center;">
                            <button type="submit" class="btn btn-dark btn-lg">Insertar</button>
                            <a class="btn btn-danger btn-lg" href="cliente.jsp">Regresar</a><br/>
                        </p> 
                        <c:if test="${mensaje != null}">
                            <div class="" style="padding: 10px;">
                                ${mensaje}
                            </div>
                        </c:if>
                    </form>
                </form>
            </div>
            <div class="col-sm-6">
                <img class="imagen rounded "src="IMG/cliente.jpg" alt="alt"/>
            </div> 
        </div>
        <br/>



    </body>
</html>
