<%-- 
    Document   : menu
    Created on : 23/07/2022, 11:33:17 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/navbar_cliente.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Edu+VIC+WA+NT+Beginner:wght@500&family=Mochiy+Pop+One&family=Montserrat:wght@500&family=Poppins:ital@1&display=swap" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <!--
        <style>
            body{
                background-image: url('img/fondo-menu.jpg');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%;
                margin: 0;
                padding: 0;
                line-height: 1.5;
            }
        </style>
        -->
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

        <br><br>
        <div class="container ">
            <div class="row align-items-start">
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/Cau-cau.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">CAU CAU DE POLLO</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/ajigallina.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">AJI DE GALLINA</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/anticucho.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">ANTICUCHO</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <br>
        <div class="container">
            <div class="row align-items-start">
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/ceviche.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">CEVICHE DE PESCADO</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/lomo-saltado.PNG" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">LOMO SALTADO</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/tallarin.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">TALLARINES ROJOS</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <br>
        <div class="container">
            <div class="row align-items-start">
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/pachamanca.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">PACHAMANCA DE POLLO</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/arrozpollo.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">ARROZ CON POLLO</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 20rem;">
                        <img src="img/causa.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">CAUSA DE POLLO</h5>
                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                            <a href="#" class="btn btn-primary">COMPRAR</a>
                        </div>
                    </div>
                </div>

            </div>
            <br><br><br><br>
            <div  class="card mb-6 container" style="max-width: 600px; ">
                <div class="row g-0">
                    <div class="col-md-8">
                        <img src="img/qr.jpeg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-4">
                        <div class="card-body">
                            <h5 style="font-family:'Edu VIC WA NT Beginner', cursive;
                                font-family: 'Mochiy Pop One', sans-serif;
                                font-family: 'Montserrat', sans-serif;
                                font-family: 'Poppins', sans-serif;
                                font-family: 'Ubuntu', sans-serif; font-size: 30px "class="card-title"><b> MENU</b></h5>
                            <p class="card-text">Ahora llevanos a cualquier lado!</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br><br><br><br>

        <%@include file="include/footer.jsp"%>

        <script src="js/js.js" type="text/javascript"></script>

    </body>

</html>
