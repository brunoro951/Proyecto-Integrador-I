
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar cliente</title>
        <link href="css/letra.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo-logo.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo-actualizar-cliente.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>

        <br>  
        <br>

        <h1  class="letra" align="center">Agregar Empleado</h1>
        <br>  
        <br>
        <div class="d-flex">
            <div class="col-sm-6">
                <form action="Empleado" method="post" style="margin: auto; display: table"> 
                    <input type="hidden" name="accion" value="INS"/>            

                    <br>
                    <br>
                    <br>

                    <form class="form form-control">
                        <label>DNI</label> 
                        <input  class="form-control" type="number" min="1" name="txtdni" style="width: 200%"
                                value="${empleado.dni}" placeholder="Ingrese el DNI" required/>
                        <br>
                        <label>Nombre</label> 
                        <input  class="form-control" type="text" name="txtNombre" style="width: 200%"
                                value="${empleado.nom}" placeholder="Ingrese el nombres" required/>
                        <br>
                        <label>Apellido</label> 
                        <input  class="form-control" type="text" name="txtApellido" style="width: 200%"
                                value="${empleado.apellido}" placeholder="Ingrese el apellidos" required/>
                        <br>
                        <label>Salario</label> 
                        <input  class="form-control" type="number" name="txtsalario" style="width: 200%"
                                value="${empleado.salario}" placeholder="Ingrese el salario" required/>
                        <br>
                        <label>Telefono</label> 
                        <input class="form-control" type="number" min="1" style="width: 200%"
                               value="${empleado.telefono}" name="txtTelefono" placeholder="Ingrese el número telefonico" required/>
                        <br>

                        <label>Estado</label> 

                        <select name="txtestado" value="${empleado.estado}" class="form-control" style="width: 400px">
                            <option value="${empleado.estado}" readonly selected>Tipo actual : ${empleado.estado}</option>
                            <option value="1">Activo</option>
                            <option value="0">Desactivo</option>
                        </select>
                        <br/>



                        <label>User</label> 
                        <input  class="form-control" type="text" name="txtUser" style="width: 200%"
                                value="${empleado.user}" placeholder="Ingrese el usuario" required/>
                        <br>
                        <label>Contraseña</label> 
                        <input  class="form-control" type="number" name="txtContra" style="width: 200%"
                                value="${empleado.contraseña}" placeholder="Ingrese la contraseña" required/>
                        <br>
                        <label>Tipo</label> 
                        <br>  
                        <select name="txttipo" value="${empleado.tipo}" class="form-control" style="width: 400px">
                            <option value="${empleado.tipo}" readonly selected>Tipo actual : ${empleado.tipo}</option>
                            <option value="empleado">empleado</option>
                            <option value="admin">administrador</option>
                        </select>
                        <br/>

                        <p style="text-align: center;">
                            <button  type="submit" class="btn btn-dark btn-lg">Actualizar</button>

                            <a  href="empleado.jsp" class="btn btn-danger btn-lg" >Regresar</a><br>
                        </p>
                        <c:if test="${mensaje != null}">
                            <div>${mensaje}</div>
                        </c:if>

                    </form>
                </form>
            </div>
            <div class="col-sm-6">
                <img class="imagen rounded "src="IMG/empleado.jpg" alt="alt"/>
            </div>
        </div>       

    </body>
</html>