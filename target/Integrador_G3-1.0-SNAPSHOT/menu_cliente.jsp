<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/bffee88f87.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Restaurante</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Controlador2?accion=home&idcli=${usuariooo.getId_cliente()}">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="reserva.jsp">Reserva</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador2?accion=Carrito&idcli=${usuariooo.getId_cliente()}"><i class="fas fa-cart-plus">(<label style="color: darkorange">${contador}</label>)</i>Carrito</a>
                        </li>
                    </ul>

                    <div class="dropdown">
                        <button style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Cliente : ${usuariooo.getNombre()}
                        </button>
                        <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#">ID del Cliente: ${usuariooo.getId_cliente()}</a></li>
                            <li><a class="dropdown-item" href="#">DNI: ${usuariooo.getDocumento()} </a></li>
                            <div class="dropdown-divider"></div>
                            <form action="Validar" method="POST">
                                <a href="index.jsp" class="dropdown-item" >Salir</a>
                            </form>
                        </ul>
                    </div>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
            </div>
        </nav>

        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-header">
                                <label>${p.nombre}</label>
                            </div>
                            <div class="card-body">
                                <i>S/${p.precio}</i>
                                <img src="ControladorIMG?id=${p.id_producto}" width="200" height="180">
                            </div>
                            <div class="card-footer text-center">
                                
                                <a href="Controlador2?accion=AgregarCarrito&id=${p.id_producto}&idcli=${usuariooo.getId_cliente()}" class="btn btn-outline-info">Agregar a carrito</a>
                                <a href="Controlador2?accion=Comprar&id=${p.id_producto}&idcli=${usuariooo.getId_cliente()}" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
