
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="css/estilo-actualizar-cliente.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo-logo.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar Estado</title>

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
                <h1><div align="center">Actualizar Venta</div></h1>
                <form action="Historial" method="post" style="margin: auto; display: table"> 
                    <input type="hidden" name="accion" value="UPD"/>            
                    <input type="hidden" name="txtId_venta" value="${ventas.id}"/>

                    <form class="form form-control">
                        <br/>
                        <label>Id cliente</label>
                        <br>
                        <input type="text" name="txtIdCliente" class="form-control" style="width: 400px"
                               value="${ventas.idcliente}" placeholder="IdCliente" readonly>
                        <br/>
                        <label>Id Empleado</label>
                        <br>
                        <input type="text" name="txtIdEmpleado" class="form-control" style="width: 400px"
                               value="${ventas.idempleado}" placeholder="IdEmpleado" readonly>
                        <br>
                        <label>Mesa</label>
                        <br>
                        <input type="text" name="txtIdEmpleado" class="form-control" style="width: 400px"
                               value="${ventas.mesa_id}" placeholder="IdEmpleado" readonly>
                        <br>
                        <label>Tipo</label>
                        <br>
                        <input type="text" name="txtIdEmpleado" class="form-control" style="width: 400px"
                               value="${ventas.tipo}" placeholder="IdEmpleado" readonly>
                        <br>
                        <label>Numero de Serie</label>
                        <br>
                        <input type="text" name="txtNumSerie" class="form-control" style="width: 400px"
                               value="${ventas.numserie}" placeholder="NumeroSerie" readonly>              
                        <br>
                        <label>fecha</label>
                        <br>
                        <input type="text" name="txtfecha" class="form-control" style="width: 400px"
                               value="${ventas.fecha}" placeholder="fecha" readonly>   
                        <br>
                        <label>Monto</label>
                        <br>
                        <input type="text" name="txtMonto" class="form-control" style="width: 400px"
                               value="${ventas.monto}" placeholder="monto" readonly>   
                        <br>
                        <label>Estado</label> 
                        <br>  
                        <select name="txtEstado" value="${ventas.estado}" class="form-control" style="width: 400px">
                            <option value="${ventas.estado}" readonly selected>Estado actual : ${ventas.estado}</option>
                            <option value="1">Aprobado</option>
                            <option value="0">Cancelado</option>
                        </select>
                            <label>Estado 1 = Aprobado</label> <br>
                            <label>Estado 2 = Cancelado</label>
                        <br/>

                        <br/><p style="text-align: center;">
                            <button type="submit" class="btn btn-dark btn-lg">Actualizar</button>
                            <a href="historial.jsp" class="btn btn-danger btn-lg" >Regresar</a><br/>
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
