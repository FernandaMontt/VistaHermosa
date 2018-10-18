<%-- 
    Document   : VerPerfil
    Created on : 08-10-2018, 20:35:23
    Author     : note
--%>

<%@page import="DTO.PermisoDTO"%>
<%@page import="Funciones.Fechas"%>
<%@page import="DAO.UsuarioPerfilDAO"%>
<%@page import="DAO.UsuarioCargoDAO"%>
<%@page import="DAO.UsuarioDepartamentoDAO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/favicon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" ></script>
        <script type="text/javascript" src="js/jquery.dataTables.js" ></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js" ></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js" ></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js" ></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js" ></script>
        <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js" ></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.2.6/js/dataTables.select.min.js" ></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js" ></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js" ></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js" ></script>
        <script type="text/javascript" src="js/popper.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        
        <title>Sistema de Gestión de Permisos</title>

        <style>
            html, body{height:100%; width:100%;}
            #tabs .nav-tabs .nav-item.show .nav-link, .nav-tabs .nav-link.active { border-bottom: 4px solid !important; }
            
            .body-block{
                background:#12237a;
                background:-webkit-linear-gradient(to bottom,#12237a,rgb(255, 255, 255));
                background:linear-gradient(to bottom,#12237a,rgb(255, 255, 255));
                width:100%;height:100%;
               }
            .container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
        </style>
    </head>
    <body style="padding-top: 50px;">
        <section>
            <%
                String mensajeError = (String)request.getSession().getAttribute("mensajeError");
                request.getSession().setAttribute("mensajeError", null);
                
                if((UsuarioDTO)request.getSession().getAttribute("usuarioDTO") == null){
                    mensajeError = "Ingrese a su cuenta por favor.";
                    request.getSession().setAttribute("mensajeError", mensajeError);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
                UsuarioDTO usuario = (UsuarioDTO)request.getSession().getAttribute("usuarioDTO");
                PermisoDTO permiso = (PermisoDTO)request.getSession().getAttribute("permisoDTO");

                //UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioPerfilDAO();
                UsuarioDepartamentoDAO usuarioDepartamentoDAO = new UsuarioDepartamentoDAO();
                UsuarioCargoDAO usuarioCargoDAO = new UsuarioCargoDAO();
                UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioPerfilDAO();
                
            

            %>
        </section> <!-- CARGAR DATOS -->
        <section>
            <% if(mensajeError != null){ %>
            <div class="modal" id="modalMensaje" tabindex="-1"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="false">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="exampleModalLabel">Municipalidad Vista Hermosa</h5>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </div>
                    <div class="modal-body">
                      <p><%=mensajeError %></p>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                  </div>
                </div>
              </div>
            <% } %>
        </section> <!-- MODAL -->
        <nav style="position: fixed; width: 100%; z-index: 1; top: 0;" class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"><img class="d-block img-fluid" src="imagenes/mvh7.png" height="40" width="40" alt="logo municipalidad"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link"><strong>Bienvenido(a) <%=usuario.getNombre() %> <%= usuario.getApellido() %> - <%=usuarioPerfilDAO.read(usuario.getId_perfil()).getPerfil() %></strong></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Opciones
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="verPerfil.jsp">Ver Perfil</a>
                            <a class="dropdown-item" href="cambiarClave.jsp">Cambiar Clave</a>
                        </div>
                    </li>
                </ul>
                <a href="Regresar"     class="btn btn-outline-secondary" style="border-radius: 5px 0 0 5px;"><i class="fas fa-backward"></i> Regresar</a>
                <a href="CerrarSesion" class="btn btn-outline-secondary" style="border-radius: 0 5px 5px 0;"><i class="fas fa-sign-out-alt"></i> Cerrar Sesión</a>
            </div>
        </nav> <!-- HEADER -->
        
        <section class="body-block">
            <br>
            <div class="container col-6">
                <br>
                <table class="table table-hover dataTable no-footer">
                    <thead>
                        <th style="font-size:25px; text-align: center" scope="col" colspan="2">
                            <%=usuario.getNombre() %> <%=usuario.getApellido() %>
                        </th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Departamento:</td>
                            <td><%=usuarioDepartamentoDAO.read(usuario.getId_departamento()).getNombre() %></td>
                        </tr>
                        <tr>
                            <td>Cargo:</td>
                            <td><%=usuarioCargoDAO.read(usuario.getId_cargo()).getNombre() %></td>
                        </tr>

                        <tr>
                            <td>Rut:</td>
                            <td><%=usuario.getRut() %></td>
                        </tr>
                        <tr>
                            <td>Usuario:</td>
                            <td><%=usuario.getUsuario() %></td>
                        </tr>
                            <td>Años de Trabajos:</td>
                            <td><%=usuario.getAnios_trabajados() %></td>
                        </tr>
                        <tr>
                            <td>Correo Electrónico:</td>
                            <td><a href="mailto:<%=usuario.getCorreo_empresa() %>"><%=usuario.getCorreo_empresa() %></a></td>
                        </tr>
                        <tr>
                            <td>Fecha de Contrato</td>
                            <td></td> 
                        </tr>
                    </tbody>
                </table>
                <br>
            </div>
        </section>       
    </body>
</html>
