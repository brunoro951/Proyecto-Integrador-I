<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>RegistrarVenta</title>

        <style>
            @media primt{
                .parte1, .btn,.accion{
                    display:none;
                }
            }
            .redondeado {
                border-radius: 5px;
            }
        </style>

    </head>
    <body>

        <section class="container">

            <center><img src="img/logo-login.PNG" width="200" height="200" ></center>
            <br>

        </section> 
        <%@include file="include/menubar.jsp"%>

        <br><br>

        <div class="d-flex">
            <div class="col-sm-4">

                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">

                            <div class="form-group">
                                <label><b>Datos del Empleado</b></label>
                            </div>
                            <br>
                            <input type="number" name="codigoempleado"  value="${d.getId()}" class="redondeando" placeholder="COD" required>

                            <input type="submit" name="accion" value="BuscarEmpleado" class="btn btn-outline-info ">
                            &nbsp;
                            &nbsp;
                            <input type="text" name="nombresempleado" value="${d.getNom()}" placeholder="Datos Empleado" class="form-control" readonly>

                            <br>

                            <div class="form-group">
                                <label><b>Datos del Cliente</b></label>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="number" name="codigocliente" value="${c.getDocumento()}" class="form-control" placeholder="DNI" >

                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info ">
                                    &nbsp;
                                    <br><!-- comment -->

                                </div>
                                &nbsp;
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNombre()}" placeholder="Datos Clientes" class="form-control" readonly>
                                </div>
                                
                            </div>
                                <br>
                            <div class="form-group d-flex">
                                <label><b>Número de Mesa</b></label>&nbsp;&nbsp;&nbsp;
                                <div class="col-sm-6 d-flex">
                                <select name="txtmesa" value="${mesaa}" class="form-control">
                                <option value="${mesaa}" readonly selected>Mesa actual : ${mesaa}</option>
                                <option value="1"> 1</option>
                                <option value="2"> 2 </option>
                                <option value="3">3</option>
                                <option value="4">4</option><!-- comment -->
                                <option value="5"> 5</option>
                                <option value="6"> 6</option>
                                <option value="7"> 7</option>
                                <option value="8"> 8</option>
                                <option value="9">Para Llevar</option>
                            </select>
                            </div></div>

                            <br>
                            <div class="form-group">
                                <label><b>Datos Productos</b></label>
                            </div>
                            <br>

                            <div class="form-group d-flex">
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <input type="number" name="codigoproducto" class="form-control" value="${producto.getId_producto()}"  min="1" value="1" placeholder="codigo" >
                                        <button type="submit" name="accion" value="BuscarProducto"  class="btn btn-outline-info">Buscar</button>
                                        &nbsp;

                                    </div>
                                    &nbsp;
                                    <div class="col-sm-6">
                                        <input type="text" name="nomproducto" value="${producto.getNombre()}" placeholder="Datos Productos" class="form-control" readonly>
                                    </div>

                                </div>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-4">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="S/0.00" readonly>
                                </div>
                                &nbsp;
                                &nbsp;

                                <div class="col-sm-3">
                                    <input type="number" name="cant" value="1" min="1" max="${producto.getStock()}" class="form-control">

                                </div>
                                &nbsp;
                                &nbsp;
                                <div class="col-sm-4">
                                    <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control" readonly>
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                            </div>
                        </div>
                        <center>
                            <c:if test="${mensaje != null}">
                                <div>${mensaje}</div>
                            </c:if>
                        </center>
                    </form>
                </div>
            </div>  
                              &nbsp;
                                &nbsp;  
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-3 ml-auto">
                            <label class="col-sm-6">Nro.Serie :</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control col-sm-2" readonly>

                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>


                            <a href="Controlador?menu=NuevaVenta&accion=default&&mesa=0" class="btn btn-danger">Cancelar</a>
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="S/. ${totalpagar}0" class="form-control" readonly>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
