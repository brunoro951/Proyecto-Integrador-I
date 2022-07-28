
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="css/estilo-actualizar-cliente.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo-logo.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar cliente</title>

    </head>
    <body>
        <section class="container">
            <header class="fila">
                <center><img src="img/logo-login.PNG" width="200" height="200" ></center>
        <br>
            </header> 
        </section> 

        <%@include file="include/menubar.jsp"%>
        <br/>
        <br/>
        <br/>

        <div class="d-flex">
            <div class="col-sm-6">
                <h1><div align="center">Actualizar Cliente</div></h1>
                <form action="Cliente" method="post" style="margin: auto; display: table"> 
                    <input type="hidden" name="accion" value="UPD"/>            
                    <input type="hidden" name="txtId_cliente" value="${cliente.id_cliente}"/>

                    <form class="form form-control">
                        <br/>
                        <label>Nombre</label>
                        <br>
                        <input type="text" name="txtNombre" class="form-control" style="width: 400px"
                               value="${cliente.nombre}" placeholder="Ingrese el nombre">
                        <br/>
                        <label>Apellido</label>
                        <br>
                        <input type="text" name="txtApellido" class="form-control" style="width: 400px"
                               value="${cliente.apellido}" placeholder="Ingrese el apellido">
                        <br>
                        <label>Correo</label>
                        <br>
                        <input type="email" name="txtCorreo" class="form-control" style="width: 400px"
                               value="${cliente.correo}" placeholder="Ingrese el correo">              
                        <br>
                        <label>Telefono</label>
                        <br>
                        <input type="number" name="txtTelefono" min="1" class="form-control" style="width: 400px"
                               value="${cliente.telefono}" placeholder="Ingrese el telefono">   
                        <br>
                        <label>Documento</label>
                        <br>
                        <input type="number" name="txtDocumento" min="1" class="form-control" style="width: 400px"
                               value="${cliente.documento}" placeholder="Ingrese el documento">   
                        <br>
                        <label>Dirección</label>
                        <br>
                        <input type="text" name="txtdireccion" min="1" class="form-control" style="width: 400px"
                               value="${cliente.direccion}" placeholder="Ingrese el documento">   
                        <br>
                        
                        

                        <br/><p style="text-align: center;">
                            <button type="submit" class="btn btn-dark btn-lg">Actualizar</button>
                            <a href="cliente.jsp" class="btn btn-danger btn-lg" >Regresar</a><br/>
                        </p>
                        <c:if test="${mensaje != null}">
                            <div>${mensaje}</div>
                        </c:if>
                        </p>               
                    </form>
                </form>

            </div>

            <div class="col-sm-6">
                <img class="imagen rounded shadow-lg p-3 mb-5 bg-secondary"src="IMG/dark.jpg" alt="alt"/>
            </div>    
        </div>
    </body>
</html>
