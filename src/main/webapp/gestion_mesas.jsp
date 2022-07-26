<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Edu+VIC+WA+NT+Beginner:wght@500&display=swap" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <br><br>
        <nav class="navbar navbar-expand-lg navbar-dark container" style="background-color: #F2C43D;">
            <a class="navbar-brand" href="#">Peruvian Flavors</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler8"
                    aria-controls="navbarToggler8" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarToggler8">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">EMPLEADOS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">RESERVAS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">HISTORIAL</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">ESTADISTICAS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">GESTION DE MESAS</a>
                    </li>
                </ul>
            </div>
        </nav>
        <br><br>
        <div class="letra text-center container">
            <h1>GESTION DE MESAS</h1> 
        </div>
        <br><br>
        <div class="container">
            <div class="row">
                <div class="col-4 col-sm-4">
                    <div class=" text-center card col-sm-15">
                        <table class="table">
                            <tr>
                                <th>ID</th>
                                <th>Mesa</th>
                                <th>Hora</th>
                                <th>Dia</th>
                            </tr>

                            <tr>
                                <th>ID</th>
                                <td><c:out value="$"/></td>
                            <td><c:out value="$"/></td>
                            <td><c:out value="$"/></td>
                        </table>
                    </div>
                </div>
                <div class="col-6 col-sm-8">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                                <div class="dropdown" aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 1
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col order-5">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                                <div class="dropdown "aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 3
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col order-1">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                               <div class="dropdown" aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 2
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><br><br>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                                <div class="dropdown" aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 4
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col order-5">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                                <div class="dropdown" aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 6
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col order-1">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                                <div class="dropdown" aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 5
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br><br>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                                <div class="dropdown" aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 7
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col">
                                <img style="width: 200px;height: 200px;" src="img/mesas.png" alt="alt"/>
                                <br><br>
                                <div class="dropdown" aria-labelledby="dropdownMenuButton1">
                                    <button class="btn btn-secondary dropdown-toggle btn btn-warning text-light" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                       RESERVAR MESA 8
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Disponible</a></li>
                                        <li><a class="dropdown-item" href="#">Reservado</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col order-1">

                            </div>
                        </div>
                    </div>
                </div>            
            </div>
        </div>
        <br><br><br><br>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

    </body>
</html>
