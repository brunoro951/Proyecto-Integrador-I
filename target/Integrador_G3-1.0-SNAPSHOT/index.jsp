<%-- 
    Document   : index
    Created on : 17/07/2022, 07:47:46 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/diseño.css" rel="stylesheet" type="text/css"/>
        <link href="css/carta.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Edu+VIC+WA+NT+Beginner:wght@500&display=swap" rel="stylesheet">
    </head>
    <body>
        <!-- Header -->
        <section id="header">
            <div class="header container">
                <div class="nav-bar">
                    <div class="brand">
                        <a href="#hero">
                            <h1>Peruvian Flavors</h1>
                        </a>
                    </div>
                    <div class="nav-list">
                        <div class="hamburger">
                            <div class="bar"></div>
                        </div>
                        <ul>
                            <li><a href="" data-after="Home">Inicio</a></li>
                            <li><a href="" data-after="Service">Nosotros</a></li>
                            <li><a href="" data-after="Projects">Menu</a></li>
                            <li><a href="" data-after="About">Reserva</a></li>
                            <li><a href="" data-after="Contact">Inisio Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Header -->


        <!-- Hero Section  -->
        <section id="hero">
            <div class="hero container">
                <div>
                    <h1>La  <span></span></h1>
                    <h1>Verdadera Cocina  <span></span></h1>
                    <h1>Autentica! <span></span></h1>
                    <a href="#projects" type="button" class="cta">Nosotros</a>
                </div>
            </div>
        </section>

        <!-- comment -->

        <div class="containerz">

            <div class="cardz">
                <div >
                    <img class="img" src="img/lomo-saltado.PNG" alt="alt"/>
                </div>
                <div class="right-column">
                    <div>
                    </div>
                    <h1 class="letra section-title "><b>Bienvenidos A Nuestro Restaurante</b>
                    </h1><br>
                    <p>Hasta la actualidad, la empresa “PERUVIAN FLAVORS” es 
                        un restaurante de comidas tipicas del Perú en donde 
                        por mucho tiempo ha tenido un proceso manual que hasta
                        el día de hoy es ineficiente y ha perjudicado a la 
                        empresa económicamente por su mala administración en 
                         </p>
                </div>

            </div>
        </div>


        <!-- comment -->



        <section>
            <h5 class="section-title"><b><span>Platillos</span></b></h5>
            <h1 class="section-title"><b>Mas Populares</b></h1><br>
            <div class="containers">

                <div class="card">
                    <img src="img/ceviche.jpg">
                    <h4>Naturaleza</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel, excepturi unde?</p>
                </div>

                <div class="card">
                    <img src="img/anticucho.jpg">
                    <h4>Comida</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel, excepturi unde?</p>
                </div>

                <div class="card">
                    <img src="img/lomo-saltado.PNG">
                    <h4>Tecnología</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel, excepturi unde?</p>
                </div>
            </div>
        </section><br><br><br><br><br><br>



        <script src="js/js.js" type="text/javascript"></script>

        <!-- End Footer -->

    </body>
</html>
