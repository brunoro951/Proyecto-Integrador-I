<%-- 
    Document   : registro
    Created on : 25/07/2022, 06:45:42 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/registro.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <section class="form-register">
            <h4>REGISTRO</h4>
            <input class="controls" type="text" name="nombres" id="nombres" placeholder="Ingrese su Nombre">
            <input class="controls" type="text" name="apellidos" id="apellidos" placeholder="Ingrese su Apellido">
            <input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su Correo">
            <input class="controls" type="password" name="correo" id="correo" placeholder="Ingrese su Contraseña">
            <p>Estoy de acuerdo con <a href="#">Terminos y Condiciones</a></p>
            <input class="botons" type="submit" value="Registrar">
            <p><a href="#">¿Ya tengo Cuenta?</a></p>
        </section>
    </body>
</html>
