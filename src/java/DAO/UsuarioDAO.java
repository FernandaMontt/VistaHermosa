/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import DTO.UsuarioDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author note
 */
public class UsuarioDAO {
    
    PreparedStatement ps;
    
    private static final String SQL_UPDATE = "UPDATE USUARIO SET id_usuario=?, rut=?, nombre=?, apellido=?, usuario=?, pass=?, correo_empresa=?, f_legal=?, p_administrativo=?, p_parental=?, p_fallecimiento=?, anios_trabajados=?, id_asistencia=?, id_tipo_contrato=?, id_perfil=?, id_cargo=?, id_departamento=?, genero=?, fecha_inicio=?, fecha_termino=?, estado=? WHERE usuario=?";
    
    private static final String SQL_UPDATE_CLAVE = "UPDATE USUARIO SET PASS=? WHERE USUARIO=?";
    private static final String SQL_UPDATE_ADMINISTRATIVO = "UPDATE USUARIO SET P_ADMINISTRATIVO=? WHERE USUARIO=?";
    private static final String SQL_UPDATE_LEGAL = "UPDATE USUARIO SET F_LEGAL=? WHERE USUARIO=?";

    
    private static final String SQL_READ = "SELECT * FROM USUARIO WHERE RUT = ?";
    private static final String SQL_READALL = "SELECT * FROM USUARIO";
    private static final String SQL_READ_PERFIL_DEPARTAMENTO = "SELECT * FROM USUARIOS WHERE PERFIL=? AND DEPARTAMENTO=?";
    
    private static final Conexion con = Conexion.iniciarConexion();
    
    /**
     *
     * @param aux
     * @return
     */
    public boolean update(UsuarioDTO aux) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            
            ps.setInt(1, aux.getId_usuario());
            ps.setString(2, aux.getRut());
            ps.setString(3, aux.getNombre());
            ps.setString(4, aux.getApellido());
            ps.setString(5, aux.getPass());
            ps.setString(6, aux.getCorreo_empresa());
            ps.setInt(7, aux.getF_legal());
            ps.setInt(8, aux.getP_administrativo());
            ps.setInt(9, aux.getP_parental());
            ps.setInt(10, aux.getP_fallecimiento());
            ps.setInt(11, aux.getAnios_trabajados());
            ps.setInt(12, aux.getId_asistencia());
            ps.setInt(13, aux.getId_tipo_contrato());
            ps.setInt(14, aux.getId_perfil());
            ps.setInt(15, aux.getId_cargo());
            ps.setInt(16, aux.getId_departamento());
            ps.setString(17, aux.getUsuario());
            ps.setString(18, aux.getGenero());
            ps.setDate(19, new java.sql.Date(aux.getFecha_inicio().getTime()));
            ps.setDate(20, new java.sql.Date(aux.getFecha_termino().getTime()));
            ps.setInt(21, aux.getEstado());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception  ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.cerrarConexion();
        }
        return false;
    }

    /**
     *
     * @param clave
     * @param rut
     * @return
     */
    public boolean update_Clave(String pass, String rut) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE_CLAVE);
            ps.setString(1, pass);
            ps.setString(2, rut);
            if (ps.executeUpdate() > 0) { return true; }
        } catch (Exception  ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.cerrarConexion();
        }
        return false;
    }

    /**
     *
     * @param administrativo
     * @param rut
     * @return
     */
    public boolean update_Administrativo(int administrativo, String rut) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE_ADMINISTRATIVO);
            ps.setInt(1, administrativo);
            ps.setString(2, rut);
            if (ps.executeUpdate() > 0) { return true; }
        } catch (Exception  ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.cerrarConexion();
        }
        return false;
    }

    /**
     *
     * @param legal
     * @param rut
     * @return
     */
    public boolean update_Legal(int legal, String rut) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE_LEGAL);
            ps.setInt(1, legal);
            ps.setString(2, rut);
            if (ps.executeUpdate() > 0) { return true; }
        } catch (Exception  ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            con.cerrarConexion();
        }
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    public UsuarioDTO read(Object key) {
        ResultSet rs;
        UsuarioDTO usuario = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13) , rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getString(18), rs.getDate(19), rs.getDate(20), rs.getInt(21));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }

    /**
     *
     * @return
     */
    public ArrayList<UsuarioDTO> readAll() {
        ArrayList<UsuarioDTO> usuarios = null;
        try {
            usuarios = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13) , rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getString(18), rs.getDate(19), rs.getDate(20), rs.getInt(21)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
    }

    /**
     *
     * @param key1
     * @param key2
     * @return
     */
    public UsuarioDTO read_Perfil_Departamento(Object key1, Object key2) {
        ResultSet rs;
        UsuarioDTO usuario = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ_PERFIL_DEPARTAMENTO);
            ps.setString(1, key1.toString());
            ps.setString(2, key2.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13) , rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getString(18), rs.getDate(19), rs.getDate(20), rs.getInt(21));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }
}
