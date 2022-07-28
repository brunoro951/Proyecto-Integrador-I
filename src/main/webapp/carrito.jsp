
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="jquery/jquery-3.6.0.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
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

        <div class="container mt-4">
            <h3>Carrito</h3>
            <br>
            <form action="Controlador2" method="POST">
                <input type="hidden" name="idcli" value="${usuariooo.getId_cliente()}"/>
                <div class="row">
                    <div class="col-sm-8">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ITEM</th>
                                    <th>NOMBRES</th>
                                    <th>DESCRIPCION</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>SUBTOTAL</th>
                                    <th>ELIMINAR</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="car" items="${carrito}">
                                    <tr>
                                        <td>${car.getItem()}</td>
                                        <td>${car.getNombres()}</td>
                                        <td>${car.getDescripcion()}
                                            <img src="ControladorIMG?id=${car.getIdproducto()}" width="100" height="100">
                                        </td>
                                        <td>${car.getPrecioCompra()}</td>
                                        <td>
                                            <input type="hidden" id="idpro" value="${car.getIdproducto()}">
                                            <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1">
                                        </td>
                                        <td>${car.getSubTotal()}</td>
                                        <td>

                                            <a  href="Controlador2?accion=Delete&idp=${car.getItem()}&idcli=${usuariooo.getId_cliente()}" class="btn btn-danger bt-block" id="btnDelete" >eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm-4">
                        <div clas="card">
                            <div clas="card-header">
                                <h3>Generar Compra</h3>
                            </div>
                            <div class="card-body"> 
                                <label>Número de Serie del Pedido:</label>
                                <input type="text" value="${nserie}" name="txtserie" readonly="" class="form-control" >
                                <br>
                                <label>Tipo de Pedido :</label>
                                <select name="txttipo" value="${tipo}" class="form-control" style="width: 400px">
                                    <option value="${tipo}" readonly selected>Estado actual : ${tipo} </option>
                                    <option value="Delivery">Delivery</option>
                                    <option value="Recojo_Tienda">Recojo en Tienda</option>
                                </select>
                                <br>
                                <label>Total a pagar:</label>
                                <input type="text" value="${Totalpagar}" name="txttotal" readonly="" class="form-control">
                            </div>
                            <div class="card footer">
                                <button type="submit" name="accion" value="GenerarCompra" class="btn btn-info btn-block">Generar Compra</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>               

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </body>
</html>
