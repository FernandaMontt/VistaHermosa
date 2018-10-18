<%-- 
    Document   : Contactanos
    Created on : 12-10-2018, 18:15:09
    Author     : note
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/GDD sin fondo.png">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" ></script>
        <script type="text/javascript" src="js/popper.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        
        <title>Sistema de Gestión de Permisos</title>
        
        <style type="text/css">
            html, body{height:100%; width:100%;}
            .login-block{
                background:#12237a;
                background:-webkit-linear-gradient(to bottom,#12237a,rgb(255, 255, 255));
                background:linear-gradient(to bottom,#12237a,rgb(255, 255, 255));
                float:left;width:100%;height:100%;display:flex;flex-direction: column; justify-content: center;}
            .cont{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
            .banner-horizontal{ display: flex; justify-content: center;}
            .banner-vertical{display: flex; flex-direction: column; justify-content: center;}
            .login-sec{padding: 50px 30px; position:relative;}
            .login-sec .copy-text{position:absolute; width:80%; bottom:20px; font-size:13px; text-align:center;}
            .login-sec .copy-text i{color:#12237a;} /*#FEB58A*/
            .login-sec .copy-text a{color:#12237a;}
            .login-sec h2{margin-bottom:30px; font-weight:800; font-size:30px; color: rgb(15, 160, 70);}
            .login-sec h2:after{content:" "; width:100px; height:5px; background:rgb(15, 160, 70); display:block; margin-top:20px; border-radius:3px; margin-left:auto;margin-right:auto}
            .btn-login{background: rgb(15, 160, 70); color:#fff; font-weight:600;}
        </style> <!-- CARGAR ESTILOS -->
        
    </head>
    <body>
        <div>
            <nav>
               <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                <a class="btn btn-success nav-item nav-link active" href="Menu.jsp" aria-selected="true">Menu</a>
                <a class="btn btn-success nav-item nav-link" href="index.jsp" aria-selected="false">Sistema de ingreso</a>
                <a class="btn btn-success nav-item nav-link" href="Contactanos.jsp" aria-selected="false">Contactanos</a>
               </div>
            </nav>
        </div>
        <section class="login-block">
            <div class="container cont">
                <div class="row">
                    <div class="col-md-6 login-sec">
                        <h2 class="text-center">Contactanos</h2>
                        
                    </div>
                    <div class="col-md-6 banner-horizontal">
                        <div class="banner-vertical">
                            <img class="d-block img-fluid" src="imagenes/mvh7.png" alt="logo municipalidad">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <footer style="position:absolute;z-index: 1" class="footer">
      <div class="container">
        <span class="text-muted"></span>
      </div>
    </footer>
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script type="text/javascript">$('#modalMensaje').modal('show');</script>
    </body>
</html>
