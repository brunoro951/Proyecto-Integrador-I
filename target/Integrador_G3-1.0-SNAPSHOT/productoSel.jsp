<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Productos</title>
        <script src="jquery/jquery-3.6.0.js" type="text/javascript"></script>
        <link href="css/estilo-Producto.css" rel="stylesheet" type="text/css"/>
        <!-- Productos -->
        <script src="jsFunction/producto.js" type="text/javascript"></script>
    </head>

    <body>

        <section class="container">

            <center><img src="img/logo-login.PNG" width="200" height="200" ></center>
        <br>

        </section> 

        <%@include file="include/menubar.jsp"%>


        <!-- Inicio del cuerpo de la intranet -->
        <!--Inicio del formulario para agregar los productos-->      
        <form method="post" action="Producto" enctype="multipart/form-data" class="form-register">
            <input type="hidden" name="accion" value="INS"/>

            <h4 >AGREGAR PRODUCTO</h4>

            <label>Nombre del Producto</label><br><br>
            <input type="text" name="txtNombre" class="controls" placeholder="Ingrese el nombre" required=""><br>
            <label>Categoría del Producto</label><br><br>
            <input type="text" name="txtcategoria" class="controls" placeholder="Ingrese la Categoria" required=""><br>
            <label>Ingrese la foto</label> <br/>
                <input type="file" name="foto"/>               
                <br/> <br/> 
            <label>Precio</label><br><br>
            <input type="number" name="txtPrecio" step="0.1" class="controls" placeholder="Ingrese Precio" required=""><br>
            <label>Stock</label><br><br>
            <input type="number" name="txtStock" class="controls" placeholder="Ingrese Stock" required=""><br>
            <input type="hidden" name="txtestado" value="1"/>
            
            <br>
            <input type="submit" class="botons" value="Registrar">

        </form><br><br>



        <!--Fin del formulario para agregar los productos-->
        <c:if test="${mensaje != null}">
            <div>${mensaje}</div>
        </c:if>

        <!--Inicio de la tabla de los productos-->

        <div class="main-container ">

            <table >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Foto</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Estado</th>
                        
                        <!--Fin del boton actualizar de la tabla de productos-->                    
                        <!--Inicio del boton eliminar de la tabla de productos-->
                        <th>
                            <a href="#" onclick="productoDel();">
                                Eliminar                            
                            </a>
                        </th>
                        <!--Fin del boton eliminar de la tabla de productos-->                    
                    </tr>
                </thead>
                <!--Fin de la tabla de los productos-->
                <c:forEach var="p" items="${list}">
                    <tr>
                        <th>${p.id_producto}</th>
                        <td>${p.nombre}</td>
                        <<td><img src="Producto?accion=IMG&id_producto=${p.id_producto}" width="200" height="200"/></td>
                        <td>${p.precio}</td>
                        <td>${p.stock}</td>
                        <td>${p.estado}</td>
                        
                        <th>
                            <!--CON JAVASCRIPT-->
                            <input type="checkbox" name="id_del" value="${p.id_producto}"/>

                        </th>
                    </tr>
                </c:forEach>            
            </table>

        </div>  
        <%@include file="include/footer.jsp"%>
    </body>
    <!-- Fin del cuerpo de la intranet -->            
</html>
