/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PermisoDAO;
import DTO.PermisoDTO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author note
 */
@WebServlet(name = "MenuInterno", urlPatterns = {"/MenuInterno"})
public class MenuInterno extends HttpServlet {

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
        try{
            if((UsuarioDTO)request.getSession().getAttribute("usuarioDTO") == null){
                String mensajeError = "Ingrese a su cuenta por favor.";
                request.getSession().setAttribute("mensajeError", mensajeError);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioDTO");
            if(usuarioDTO != null){
                // LISTADO PERMISOS EMITIDOS POR DEPARTAMENTO
                ArrayList<PermisoDTO> permisosEstadoDepartamento = new ArrayList<PermisoDTO>();
                permisosEstadoDepartamento = new PermisoDAO().readAll_Estado_Departamento(1, usuarioDTO.getId_departamento());
                request.getSession().setAttribute("permisosEstadoDepartamento", permisosEstadoDepartamento);
                
                // LISTADO PERMISOS POR DEPARTAMENTO
                ArrayList<PermisoDTO> permisosDepartamento = new ArrayList<PermisoDTO>();
                permisosDepartamento = new PermisoDAO().readAll_Departamento(usuarioDTO.getId_departamento());
                request.getSession().setAttribute("permisosDepartamento", permisosDepartamento);

                

                request.getSession().setAttribute("usuarioDTO", usuarioDTO);

                request.getRequestDispatcher("MenuJefeInterno.jsp").forward(request, response);
            }else{
                String mensajeError = "Error de autentificación. Vuelva a ingresar.";
                request.getSession().setAttribute("mensajeError", mensajeError);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            
            
        } catch(NullPointerException ex) {
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
