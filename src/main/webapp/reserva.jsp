<%-- 
    Document   : reserva
    Created on : 20/07/2022, 07:12:25 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <section class="vh-100">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-xl-10">
                        <div class="card" style="border-radius: 1rem;">
                            <div class="row g-0">
                                <div class="col-md-6 col-lg-5 d-none d-md-block">
                                    <br><br><br>
                                    <img src="img/mesa.png"
                                         alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />

                                </div>
                                <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                    <div class="card-body p-4 p-lg-5 text-black">

                                        <form>

                                            <div class="d-flex align-items-center mb-3 pb-1">
                                                <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>            
                                                <span style="color: #FFA23F;"class="h1 fw-bold mb-0">RESERVA</span>        
                                            </div>

                                            <form>
                                                <div class="row d-flex">
                                                    <div class="form-group col-md-6">
                                                        <label>Nombres</label>
                                                        <input type="text" class="form-control" id="inputEmail4">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>Apellidos</label>
                                                        <input type="text" class="form-control" id="inputPassword4">
                                                    </div>
                                                </div><br>
                                                <div class="form-group">
                                                    <label >Gmail</label>
                                                    <input type="email" class="form-control" id="inputAddress" >
                                                </div><br>
                                                <div class="form-group col-md-6">
                                                    <label for="inputAddress2">DNI</label>
                                                    <input type="9999999" class="form-control" id="inputAddress2">
                                                </div><br>
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label for="inputCity">City</label>
                                                        <input type="text" class="form-control" id="inputCity">
                                                    </div><br>
                                                    <div class="form-group col-md-6">
                                                        <label for="inputState">Mesa a Reservar</label>
                                                        <select id="inputState" class="form-control">
                                                            <option selected>1</option>
                                                            <option selected>2</option> 
                                                            <option selected>3</option> 
                                                            <option selected>4</option>
                                                            <option selected>5</option>
                                                            <option selected>6</option>
                                                            <option selected>7</option>
                                                            <option selected>8</option>
                                                        </select>
                                                    </div>
                                                    <br>
                                                </div>

                                                <button type="submit" class="btn btn-primary">Enviar</button>
                                            </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
