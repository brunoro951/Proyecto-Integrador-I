<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Actualizar productos</title>
        <link href="css/estilo-Producto.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo-Producto2.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section class="container">
            <center><img src="img/logo-login.PNG" width="200" height="200" ></center>
        <br>
            
        </section> 
        <nav class="menu">
            <ul>
                <li> <a href="producto.jsp">Regresar</a> </li>
            </ul>
        </nav>
        <div>
            <form action="Producto" method="post" class=" form-register"> 
                <input type="hidden" name="accion" value="UPD"/>            
                <input type="hidden" name="txtId_producto" value="${producto.id_producto}"/>

                <h4 >ACTUALIZAR PRODUCTO</h4>
                <label>Nombre</label> <br><br>
                <input type="text" name="txtNombre" "
                       value="${producto.nombre}" placeholder="Ingrese el nombre"class="controls"/><br><br>
               <label>Ingrese la foto</label> <br/>
               <img src="Producto?accion=IMG&id_producto=${producto.id_producto}" width="200" height="200"/>
                <input type="file" name="foto"/>
                <br><br>              
                <label>Ingrese el precio</label> <br><br>
                <input type="number" name="txtPrecio"
                       value="${producto.precio}" class="controls"/><br><br>
                <label>Ingrese el stock</label> <br><br>
                <input type="number" name="txtStock"
                       value="${producto.stock}" class="controls"/><br><br>
                <button type="submit" class="botons">Actualizar</button>
                <c:if test="${mensaje != null}">
                    <div>${mensaje}</div>
                </c:if>
            </form>

        </div>

        <br><br>
        <%@include file="include/footer.jsp"%>
    </body>

</html>
