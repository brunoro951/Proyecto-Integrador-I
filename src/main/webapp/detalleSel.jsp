
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
        <script src="jsFunction/historial.js" type="text/javascript"></script>             
    </head>
    <body>
    <section class="container">

        <center><img src="img/logo-login.PNG" width="200" height="200" ></center>
        <br>

    </section> 
    <%@include file="include/menubar.jsp"%>
    <br><br>
    <center>
            <h1 class="letra">HISTORIAL DETALLE DE  PEDIDOS</h1>   
      
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
                        <th>IDDETALLEVENTA</th>
                        <th>IDPEDIDO</th>
                        <th>PRODUCTO</th>
                        <th>CANTIDAD</th>
                        <th>PRECIO</th>
                        <th>ESTADO</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="s" items="${list}">
                        <tr>
                            <th>${s.iddetalle}</th>
                            <td><c:out value="${s.idventa}"/></td>
                            <td><c:out value="${s.name}"/></td>
                            <td><c:out value="${s.cantidad}"/></td>
                            <td><c:out value="${s.precio}"/></td>
                            <td><c:out value="${s.estado}"/></td>
                            
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div> <br><br>
        
    </center>
<br><br><br><br>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</html>
