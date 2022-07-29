<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/estilo-login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login-box">
            <img src="IMG/LOGO.PNG" class="avatar" alt="Avatar Image">
            <h1>INICIO SESION</h1>
            <form action="Empleado" method="POST">
                <input type="hidden" name="accion" value="login">
                <label for="username">Ingrese el Usuario</label>
                <input type="text" name="user" placeholder="Usuario" />
                <br />
                <label for="username">Ingrese la Contraseña</label>
                <input type="password" name="pass" placeholder="Contraseña" />
                <br /><br />
                <input type="submit" value="Ingresar">
            </form>
            <c:if test="${mensaje != null}">
            <div>${mensaje}</div>
        </c:if>
        </div>   

    </body>
</html>
