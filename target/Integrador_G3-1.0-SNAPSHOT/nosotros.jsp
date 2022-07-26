<%-- 
    Document   : nosotros
    Created on : 24/07/2022, 04:36:07 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/navbar_cliente.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/navbar_cliente.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Edu+VIC+WA+NT+Beginner:wght@500&family=Mochiy+Pop+One&family=Montserrat:wght@500&family=Poppins:ital@1&display=swap" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark container d-flex" style="background-color: #273746;">
            <a style="font-family: 'Edu VIC WA NT Beginner', cursive;
               font-family: 'Mochiy Pop One', sans-serif;
               font-family: 'Montserrat', sans-serif;
               font-family: 'Poppins', sans-serif;
               font-family: 'Ubuntu', sans-serif; font-size: 30px "class="navbar-brand col-md-6" href="#">PERUVIAN FLAVORS</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler8"
                    aria-controls="navbarToggler8" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarToggler8">
                <ul class="navbar-nav ">
                    <li class="nav-item">
                        <a class="nav-link " href="#">INICIO</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">NOSOTROS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">MENU</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">RESERVA</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">INICIO SESION</a>
                    </li>
                </ul>
            </div>
        </nav>
        <br> <br>
        <div class="container">
            <div class="row align-items-start">
                <div class="col">
                    <img src="img/logo-login.PNG" alt="alt"/>
                </div>
                <div class="col">
                    <p style="font-family: cursive; font-size: 70px;color: #F2C43D">Nosotros</p>
                    <div style="text-align: justify">
                        <li>Modernos en el estilo y clásicos en el sabor.</li>
                        <br>
                        <li>Un equipo de profesionales que hemos creado el restaurante donde nos gustaría comer a diario y en las ocasiones especiales. Con menú o a la carta. Con amigos o con clientes, con tiempo para disfrutar o con algo más de prisa porque el trabajo lo requiere.

                            Firmes defensores de que calidad no está en el precio, sino en el producto.</li>
                        <br>
                        <li>Exigentes porque también somos consumidores y estamos convencidos de que la experiencia debe resultar completa.</li>
                        <br>
                        <li>Un buen restaurante ha de serlo por la comida, pero también por el trato y el entorno, por la decoración y el ambiente.</li> 
                        <br>
                        <li>Somos nuevos, pero también somos expertos. Natural Lunch, nuestro restaurante en ciudad de Lima, nos ha permitido crecer y creer. Sabemos más y queremos demostrarlo.</li> 
                    </div>
                </div>
            </div>
        </div>
        <br><br>
        <div>
            <p style="font-family: cursive; font-size: 70px;color: #F2C43D; text-align: center">GRUPO 3</p>
        </div>
        <div class="container ">
            <div class="row align-items-start">
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/integrante1.PNG" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">MARLON RODRIGO TELLO RUIZ</h5>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/integrante2.PNG" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">BRUNO VICTOR RAMIREZ ORTIZ</h5>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/Cau-cau.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">CHIPANA ARI BRAYAN RAUL</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
        <br><br>

        <div class="container">
            <div class="row align-items-start">
                <div class="col-4">
                    <div class="card" style="width: 20rem;">
                        <img src="img/Cau-cau.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">CLAURE GARCIA JOSE DAVID</h5>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/Cau-cau.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">CHUAN GARCIA ANTHONY FRANCISCO</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br><br>
        <%@include file="include/footer.jsp"%>

        <script src="js/js.js" type="text/javascript"></script>
    </body>
</html>
