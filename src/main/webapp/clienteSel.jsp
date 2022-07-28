
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link href="css/letra.css" rel="stylesheet" type="text/css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>

        <script src="jquery/jquery-3.6.0.js" type="text/javascript"></script>
        <script src="jsFunction/cliente.js" type="text/javascript"></script>             
    </head>
    <body>
    <section class="container">

        <center><img src="img/logo-login.PNG" width="200" height="200" ></center>
        <br>
    </section> 
    <%@include file="include/menubar.jsp"%>
    <br><br>
    <center>
            <h1 class="letra">Cliente</h1>   
      
        <hr class="col-sm-10"/>
    </center>

   
    <c:if test="${mensaje != null}">
        <p class="" style="padding: 10px;">${mensaje}</p>
    </c:if>



    <br/><br/>
    <center>
        <div  style="border:none" class="card col-sm-10 text-center">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Correo</th>
                        <th>Telefono</th>
                        <th>Documento</th>
                        <th>Direccion</th>
                        <th>
                            <a class="btn btn-warning" href="#" onclick="clienteUpd();">
                                Actualizar                            
                            </a>
                        </th>
                        <th>
                            <a class="btn btn-danger" href="#" onclick="clienteDel();">
                                Eliminar                            
                            </a>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="s" items="${list}">
                        <tr>
                            <th><c:out value="${s.id_cliente}"/></th>
                            <td><c:out value="${s.nombre}"/></td> 
                            <td><c:out value="${s.apellido}"/></td>
                            <td><c:out value="${s.correo}"/></td>
                            <td><c:out value="${s.telefono}"/></td>
                            <td><c:out value="${s.documento}"/></td>
                            <td><c:out value="${s.direccion}"/></td>
                            <th>
                                <!--SIN JAVASCRIPT-->
                                <!--<a href='Servicios?accion=GET&id=/*colocar id*/' >Editar</a>-->
                                <!--CON JAVASCRIPT-->
                                <input type="radio" name="id_upd" value="${s.id_cliente}"/>
                            </th>
                            <th>
                                <!--CON JAVASCRIPT-->
                                <input type="checkbox" name="id_del" value="${s.id_cliente}"/>
                            </th>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div> <br><br>
        <div class="d-grid  col-2 mx-auto">
            <a class="btn btn-dark " href="clienteIns.jsp" >Nuevo cliente</a>
        </div>
    </center>
<br><br><br><br>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</html>
