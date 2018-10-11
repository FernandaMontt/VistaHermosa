/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PermisoDAO;
import DAO.PermisoResolucionDAO;
import DAO.UsuarioDAO;
import DTO.PermisoDTO;
import DTO.PermisoResolucionDTO;
import DTO.UsuarioDTO;
import Funciones.Clave;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author note
 */
@WebServlet(name = "ActualizarPermiso", urlPatterns = {"/ActualizarPermiso"})
public class ActualizarPermiso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            
            if((UsuarioDTO)request.getSession().getAttribute("usuarioDTO") == null){
                String mensajeError = "Ingrese a su cuenta por favor.";
                request.getSession().setAttribute("mensajeError", mensajeError);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            String observacion = request.getParameter("observacion");
            int boton = Integer.parseInt(request.getParameter("boton"));
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            PermisoDAO permisoDAO = new PermisoDAO();
            
            //UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioDTO");
            
            PermisoDTO permiso = (PermisoDTO)request.getSession().getAttribute("permisoDTO");
            UsuarioDTO funcionario = usuarioDAO.read(permiso.getId_usuario());

            switch(boton){
                case 1: // SE AUTORIZA EL PERMISO
                    // SE DEBE CREAR LA RESOLUCION
                    PermisoResolucionDAO permisoResolucionDAO = new PermisoResolucionDAO();
                    PermisoResolucionDTO permisoResolucionDTO = new PermisoResolucionDTO();

                    permisoResolucionDTO.getId_resolucion();
                    permisoResolucionDTO.getFecha_resolucion();

                    if(permisoResolucionDAO.create(permisoResolucionDTO)){
                        // SE CREA CORRECTAMENTE LA RESOLUCION
                        permiso.getId_estado_permiso(); // ESTADO APROBADO

                        if(permisoDAO.update(permiso)){
                            // SE APRUEBA EL PERMISO
                            funcionario.getCorreo_empresa();
                            String mensajeError = "Se aprobó el permiso.";
                            request.getSession().setAttribute("mensajeError", mensajeError);
                            request.getRequestDispatcher("MenuInterno").forward(request, response);
                        }else{
                            String mensajeError = "No se pudo aprobar el permiso.";
                            request.getSession().setAttribute("mensajeError", mensajeError);
                            request.getRequestDispatcher("MenuInterno").forward(request, response);
                        }
                    }else{
                        String mensajeError = "Error al crear resolución del permiso.";
                        request.getSession().setAttribute("mensajeError", mensajeError);
                        request.getRequestDispatcher("MenuInterno").forward(request, response);
                    }
                    break;
                case 2: // SE RECHAZA EL PERMISO
                    String mensajeError;
                    switch(permiso.getId_tipo_permiso()){
                        case 1: // PERMISO ADMINISTRATIVO
                            permiso.getId_estado_permiso(); // ESTADO RECHAZADO
                            if(permisoDAO.update(permiso)){
                                funcionario.setP_administrativo(funcionario.getP_administrativo());
                                if(usuarioDAO.update(funcionario)){
                                    funcionario.getCorreo_empresa();
                                    mensajeError = "Se rechazó el permiso administrativo.";
                                    request.getSession().setAttribute("mensajeError", mensajeError);
                                    request.getRequestDispatcher("MenuInterno").forward(request, response);
                                }else{
                                    mensajeError = "No se pudo actualizar el usuario al rechazar el permiso legal.";
                                    request.getSession().setAttribute("mensajeError", mensajeError);
                                    request.getRequestDispatcher("MenuInterno").forward(request, response);
                                }
                            }else{
                                mensajeError = "No se pudo rechazar el permiso.";
                                request.getSession().setAttribute("mensajeError", mensajeError);
                                request.getRequestDispatcher("MenuInterno").forward(request, response);
                            }
                            break;
                        case 2: // PERMISO POR FALLECIMIENTO
                            mensajeError = "No se puede rechazar un permiso por fallecimiento.";
                            request.getSession().setAttribute("mensajeError", mensajeError);
                            request.getRequestDispatcher("AutorizarPermiso.jsp").forward(request, response);
                            break;
                        case 3: // PERMISO LEGAL
                            permiso.getId_estado_permiso(); // ESTADO RECHAZADO
                            if(permisoDAO.update(permiso)){
                                funcionario.setF_legal(funcionario.getF_legal());
                                if(usuarioDAO.update(funcionario)){
                                    funcionario.getCorreo_empresa();
                                    mensajeError = "Se rechazó el permiso legal.";
                                    request.getSession().setAttribute("mensajeError", mensajeError);
                                    request.getRequestDispatcher("MenuInterno").forward(request, response);
                                }else{
                                    mensajeError = "No se pudo actualizar el usuario al rechazar el permiso legal.";
                                    request.getSession().setAttribute("mensajeError", mensajeError);
                                    request.getRequestDispatcher("MenuInterno").forward(request, response);
                                }
                            }else{
                                mensajeError = "No se pudo rechazar el permiso.";
                                request.getSession().setAttribute("mensajeError", mensajeError);
                                request.getRequestDispatcher("MenuInterno").forward(request, response);
                            }
                            break;
                        case 4: // PERMISO PARENTAL
                            mensajeError = "No se puede rechazar un permiso parental.";
                            request.getSession().setAttribute("mensajeError", mensajeError);
                            request.getRequestDispatcher("AutorizarPermiso.jsp").forward(request, response);
                            break;
                    }
                    break;
             }
        } catch(NullPointerException ex) {
            String mensajeError = "Error inesperado (ActualizarPermiso) | " + ex.getMessage();
            request.getSession().setAttribute("mensajeError", mensajeError);
            request.getRequestDispatcher("CerrarSesion").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
