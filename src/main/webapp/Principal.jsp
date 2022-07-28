<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>Principal</title>
        
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div>
                <img src="" width="" height=""/>
            </div>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="bienvenida.jsp" target="myFrame">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="empleado.jsp" target="myFrame">Administrar Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="cliente.jsp" target="myFrame">Vista de Empleado Normal</a>
                    </li>
                    
                </ul>
            </div>

            <div class="dropdown">
                <button style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    Administrador(a) : ${empleado.getNom()}
                </button>
                <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="#">${empleado.getUser()}</a></li>
                    <li><a class="dropdown-item" href="#"></a></li>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <a href="index.jsp" class="dropdown-item" >Salir</a>
                    </form>
                </ul>
            </div>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </nav>

    <center>
        <div class="m-10" style="height: 650px; width: 1500px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>
    </center> 


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
