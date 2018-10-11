<%-- 
    Document   : Permiso
    Created on : 08-10-2018, 20:34:45
    Author     : note
--%>

<%@page import="DAO.PermisoResolucionDAO"%>
<%@page import="Funciones.Fechas"%>
<%@page import="DAO.UsuarioPerfilDAO"%>
<%@page import="DAO.PermisoEstadoDAO"%>
<%@page import="DAO.PermisoTipoDAO"%>
<%@page import="DAO.UsuarioCargoDAO"%>
<%@page import="DAO.UsuarioDepartamentoDAO"%>
<%@page import="DAO.PermisoMotivoDAO"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="DAO.PermisoDAO"%>
<%@page import="DTO.PermisoDTO"%>
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
        <script type="text/javascript" src="js/jspdf.js"></script>
        <script type="text/javascript" src="js/HTMLtoPDF.js"></script>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        
        <title>Sistema de Gestión de Permisos</title>

        <style>
            html, body{height:100%; width:100%;}
            #tabs .nav-tabs .nav-item.show .nav-link, .nav-tabs .nav-link.active { border-bottom: 4px solid !important; }
            
            .body-block{
                background:rgb(20, 122, 75);
                background:-webkit-linear-gradient(to bottom,rgb(8, 100, 20),rgb(255, 255, 255));
                background:linear-gradient(to bottom,rgb(8, 100, 20),rgb(255, 255, 255));
                width:100%;height:100%;
               }
            .container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
        </style>
    </head> <!-- HEAD -->
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
                
                PermisoDAO permisoDAO = new PermisoDAO();
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                

                PermisoMotivoDAO permisoMotivoDAO = new PermisoMotivoDAO();
                UsuarioDTO funcionario = usuarioDAO.read(permiso.getId_usuario());
                UsuarioDTO jefeInterno = usuarioDAO.read_Perfil_Departamento(3, funcionario.getId_departamento());
                
                UsuarioDepartamentoDAO usuarioDepartamentoDAO = new UsuarioDepartamentoDAO();
                
                UsuarioCargoDAO usuarioCargoDAO = new UsuarioCargoDAO();
                PermisoTipoDAO permisoTipoDAO = new PermisoTipoDAO();
                PermisoEstadoDAO permisoEstadoDAO = new PermisoEstadoDAO();
                UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioPerfilDAO();
                PermisoResolucionDAO   permisoResolucionDAO = new PermisoResolucionDAO();
            %>
        </section> <!-- CARGAR DATOS -->
        <section>
            <% if(mensajeError != null){ %>
            <div class="modal" id="modalMensaje" tabindex="-1"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="false">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="exampleModalLabel">SGP</h5>
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
            <a class="navbar-brand" href="#"><img class="d-block img-fluid" src="imagenes/LogoMunicipalidad-small.png" height="40" width="40" alt="logo municipalidad"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link"><strong>Bienvenido(a) <%=usuario.getNombre() %> <%= usuario.getApellido() %> - <%=usuarioPerfilDAO.read(usuario.getId_perfil()).getPerfil() %></strong></a>
                    </li>
                    
                </ul>
                <a href="Regresar"     class="btn btn-outline-secondary" style="border-radius: 5px 0 0 5px;"><i class="fas fa-backward"></i> Regresar</a>
                <a href="CerrarSesion" class="btn btn-outline-secondary" style="border-radius: 0 5px 5px 0;"><i class="fas fa-sign-out-alt"></i> Cerrar Sesión</a>
            </div>
        </nav> <!-- HEADER -->
        
        <section class="body-block">
            <br>
            <div class="container col-6">
                <div class="row-fluid">
                    <div >
                        <br>
                        <table id="tabla">
                            <thead>
                                <th><strong>Permiso <%=permiso.getId_solicitud() %></strong></th>
                                <th><%=permisoTipoDAO.read(permiso.getId_tipo_permiso()).getPermiso() %></th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Estado de Permiso:</td>
                                    <td><%=permisoEstadoDAO.read(permiso.getId_estado_permiso()).getEstado() %></td>
                                </tr>
                                <tr>
                                    <td>Funcionario: </td>
                                    <td><%=funcionario.getNombre()%> <%=funcionario.getApellido()%></td>
                                </tr>
                                <tr>
                                    <td>Rut: </td>
                                    <td><%=funcionario.getRut()%></td>
                                </tr>
                                <tr>
                                    <td>Departamento/Cargo:</td>
                                    <td><%=usuarioDepartamentoDAO.read(funcionario.getId_departamento()).getNombre() %>/<%=usuarioCargoDAO.read(funcionario.getId_cargo()).getNombre() %></td>
                                </tr>
                                <tr>
                                    <td>Fecha de Creación:</td>
                                    <td><%=Fechas.toStringFecha(permiso.getFecha_solicitud()) %></td>
                                </tr>
                                <tr>
                                    <td>Fecha de Revisión:</td>
                                    <td><%=permiso.getFecha_revision() %></td>
                                </tr>
                                <tr>
                                    <td>Fecha de Inicio:</td>
                                    <td><%=Fechas.toStringFecha(permiso.getFecha_inicio()) %></td>
                                </tr>
                                <tr>
                                    <td>Fecha de Fin:</td>
                                    <td><%=Fechas.toStringFecha(permiso.getFecha_termino()) %></td>
                                </tr>
                                <tr>
                                    <td>Motivo:</td>
                                    <td><%=permisoMotivoDAO.read(permiso.getId_motivo()).getMotivo() %></td>
                                </tr>                                                                
                                <tr>
                                    <td>Número de Decreto:</td>
                                    <form action="VerResolucion" method="POST">
                                        <td>
                                            <% if(permisoResolucionDAO.read(permiso.getId_solicitud()).getId_resolucion() != 0){%>
                                            <button class="btn btn-link" type="submit" name="id_resolucion" value="<%=permisoResolucionDAO.read(permiso.getId_solicitud()).getId_resolucion()%>"><i class="fas fa-external-link-alt"></i> <%=permisoResolucionDAO.read(permiso.getId_solicitud()).getFecha_resolucion() %></button>
                                            <%}%>
                                        </td>
                                    </form>
                                </tr>
                                
                            </tbody>
                        </table>
                    <br>
                </div>
            </div>
        </section>
        
        <script type="text/javascript">$('#modalMensaje').modal('show');</script>
        
        
    
        
        <script type="text/javascript">
            $(document).ready( function () {
                $('#tabla').DataTable({
                    "searching": false,
                    "ordering": false,

                    "language": {
                        "info": "",
                        "infoEmpty": "",
                        "infoFiltered": ""
                    },
                    "paging": false,
                    dom: 'Bfrtip',
                    buttons: [
                        { extend: 'pdf', text: 'Descargar en PDF' },
                        { extend: 'print', text: 'Imprimir Permiso' }
                    ]
                });
            } );
            
        </script>
    </body>
</html>
