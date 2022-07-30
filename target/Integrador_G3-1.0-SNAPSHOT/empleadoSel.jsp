
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

        <title>Empleados</title>

        <script src="jquery/jquery-3.6.0.js" type="text/javascript"></script>
        <script src="jsFunction/empleado.js" type="text/javascript"></script>             
        <link href="css/letra.css" rel="stylesheet" type="text/css"/>
        <style>
            .sinborde {
                border: 0;
                text-align:center;
            }
        </style>
    </head>
    <body>


        <br>
        <br>
        <br> 
    <center>
        <h1 class="letra">Empleados</h1>
        <hr class="col-sm-10"/>
    </center>    

    <c:if test="${mensaje != null}">
        <p class="" style="padding: 10px;">${mensaje}</p>
    </c:if>


    <br/><br/>
    <center>
        <div  style="border:none" class="card col-sm-10 text-center">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Salario</th>
                    <th>Telefono</th>
                    <th>Estado</th>
                    <th>User</th>
                    <th>Contraseña</th>
                    <th>Tipo</th>
                    <th>
                        <a class="btn btn-warning" href="#" onclick="EmpleadoUpd();">
                            Actualizar                            
                        </a>
                    </th>
                    <th>
                        <a class="btn btn-danger" href="#" onclick="EmpleadoDel();">
                            Eliminar                            
                        </a>
                    </th>
                </tr>
                <c:forEach var="s" items="${list}">
                    <tr>
                        <th>${s.id}</th>
                        <td><c:out value="${s.dni}"/></td>
                        <td><c:out value="${s.nom}"/></td>
                        <td><c:out value="${s.apellido}"/></td>
                        <td><c:out value="${s.salario}"/></td>
                        <td><c:out value="${s.telefono}"/></td>
                        <td><c:out value="${s.estado}"/></td>
                        <td><c:out value="${s.user}"/></td>
                        <td><c:out value="${s.contraseña}"/></td>
                        <td><c:out value="${s.tipo}"/></td>
                        <th>
                            <!--SIN JAVASCRIPT-->
                            <!--<a href='Servicios?accion=GET&id=/*colocar id*/' >Editar</a>-->
                            <!--CON JAVASCRIPT-->
                            <input type="radio" name="id_upd" value="${s.id}"/>
                        </th>
                        <th>
                            <!--CON JAVASCRIPT-->
                            <input type="checkbox" name="id_del" value="${s.id}"/>
                        </th>
                    </tr>
                </c:forEach>            
            </table>
        </div>
        <br>
        <br>
        <div class="d-grid  col-2 mx-auto">    
            <a class="btn btn-dark" href="empleadoIns.jsp">Nuevo Empleado</a>
        </div>
    </center>
    <br>
    <br>


</body>
</html>
