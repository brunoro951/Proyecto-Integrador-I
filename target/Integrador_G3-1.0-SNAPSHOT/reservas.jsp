<%-- 
    Document   : reservas
    Created on : 23/07/2022, 11:28:00 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Edu+VIC+WA+NT+Beginner:wght@500&display=swap" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <br><br>
        <nav class="navbar navbar-expand-lg navbar-dark container" style="background-color: #F2C43D;">
            <a class="navbar-brand" href="#">Peruvian Flavors</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler8"
                    aria-controls="navbarToggler8" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarToggler8">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">EMPLEADOS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">RESERVAS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">HISTORIAL</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">ESTADISTICAS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">GESTION DE MESAS</a>
                    </li>
                </ul>
            </div>
        </nav>
        <br><br>
        <div class="letras text-center container">
            <h1>RESERVAS</h1> 
        </div>
        <br><br>
        <div  style="border:none" class="card col-sm-10 text-center container">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo</th>
                    <th>fecha</th>
                    <th>Hora</th>
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

                <tr>
                    <th>ID</th>
                    <td><c:out value="$"/></td>
                <td><c:out value="$"/></td>
                <td><c:out value="$"/></td>
                <td><c:out value="$"/></td>
                <td><c:out value="$"/></td>
                <th>
                    <!--SIN JAVASCRIPT-->
                    <!--<a href='Servicios?accion=GET&id=/*colocar id*/' >Editar</a>-->
                    <!--CON JAVASCRIPT-->
                    <input type="radio" name="id_upd" value=""/>
                </th>
                <th>
                    <!--CON JAVASCRIPT-->
                    <input type="checkbox" name="id_del" value=""/>
                </th>
                </tr>

            </table>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

    </body>
</html>
