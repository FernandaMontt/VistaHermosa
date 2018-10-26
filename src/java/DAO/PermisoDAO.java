/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import DTO.PermisoDTO;
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
public class PermisoDAO {
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO SOLICITUD_PERMISO VALUES (SEQ_SOLICITUD_PERMISO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE SOLICITUD_PERMISO SET fecha_creacion=?, fecha_desde=?, fecha_hasta=?, dias=?, observacion=?, usuario=?, resolucion=?, adjunto=?, estado=?, tipo=?, motivo=? WHERE id_permiso = ?";
    private static final String SQL_READ = "SELECT * FROM SOLICITUD_PERMISO WHERE ID_SOLICITUD = ?";
    private static final String SQL_READALL = "SELECT * FROM SOLICITUD_PERMISO ORDER BY FECHA_SOLICITUD";
    
    private static final String SQL_READ_RESOLUCION = "SELECT * FROM SOLICITUD_PERMISO WHERE RESOLUCION=? ORDER BY FECHA_SOLICITUD";
    private static final String SQL_READALL_USUARIO = "SELECT * FROM SOLICITUD_PERMISO WHERE USUARIO=?";
    private static final String SQL_READALL_ESTADO = "SELECT * FROM SOLICITUD_PERMISO WHERE ESTADO=? ORDER BY FECHA_SOLICITUD";
    private static final String SQL_READALL_DEPARTAMENTO = "SELECT P.ID_PERMISO, P.FECHA_CREACION, P.FECHA_DESDE, P.FECHA_HASTA, P.DIAS, P.OBSERVACION, P.USUARIO, P.RESOLUCION, P.ADJUNTO, P.ESTADO, P.TIPO, P.MOTIVO FROM SOLICITUD_PERMISO P INNER JOIN USUARIO U ON U.RUT = P.USUARIO WHERE U.DEPARTAMENTO = ? ORDER BY FECHA_SOLICITUD";
    private static final String SQL_READALL_ESTADO_DEPARTAMENTO = "SELECT P.ID_PERMISO, P.FECHA_CREACION, P.FECHA_DESDE, P.FECHA_HASTA, P.DIAS, P.OBSERVACION, P.USUARIO, P.RESOLUCION, P.ADJUNTO, P.ESTADO, P.TIPO, P.MOTIVO FROM PERMISOS P INNER JOIN USUARIO U ON U.RUT = P.USUARIO WHERE P.ESTADO = ? AND U.DEPARTAMENTO = ? ORDER BY FECHA_SOLICITUD";
    private static final String SQL_SUM_USUARIO_ESTADO_TIPO = "SELECT SUM(DIAS) FROM PERMISOS WHERE USUARIO=? AND ESTADO=? AND TIPO=? ORDER BY FECHA_CREACION";
    private static final String SQL_PROCEDURE_SOLICITUD_PERMISO_INSERT = "SELECT PROCEDURE SOLICITUD_PERMISO_INSERT";
    
    private static final Conexion con = Conexion.iniciarConexion();
    
    /**
     *
     * @param aux
     * @return
     */
    public boolean create(PermisoDTO aux) { 
        try {          
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            
            ps.setInt(1, aux.getId_solicitud());
            ps.setDate(2, new java.sql.Date(aux.getFecha_inicio().getTime()));
            ps.setDate(3, new java.sql.Date(aux.getFecha_termino().getTime()));
            ps.setDate(4, new java.sql.Date(aux.getFecha_reincorporacion().getTime()));
            ps.setDate(5, new java.sql.Date(aux.getFecha_solicitud().getTime()));
            ps.setDate(6, new java.sql.Date(aux.getFecha_revision().getTime()));
            ps.setInt(7, aux.getId_motivo());
            ps.setInt(8, aux.getId_usuario());
            ps.setInt(9, aux.getId_tipo_permiso());
            ps.setInt(10, aux.getId_estado_permiso());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     *
     * @param aux
     * @return
     */
    public boolean update(PermisoDTO aux) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            
            ps.setInt(1, aux.getId_solicitud());
            ps.setDate(2, new java.sql.Date(aux.getFecha_inicio().getTime()));
            ps.setDate(3, new java.sql.Date(aux.getFecha_termino().getTime()));
            ps.setDate(4, new java.sql.Date(aux.getFecha_reincorporacion().getTime()));
            ps.setDate(5, new java.sql.Date(aux.getFecha_solicitud().getTime()));
            ps.setDate(6, new java.sql.Date(aux.getFecha_revision().getTime()));
            ps.setInt(7, aux.getId_motivo());
            ps.setInt(8, aux.getId_usuario());
            ps.setInt(9, aux.getId_tipo_permiso());
            ps.setInt(10, aux.getId_estado_permiso());            
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    public PermisoDTO read(Object key) {
        PermisoDTO permiso = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                permiso = new PermisoDTO(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5) , rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permiso;
    }

    /**
     *
     * @return
     */
    public ArrayList<PermisoDTO> readAll() {
        ArrayList<PermisoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new PermisoDTO(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5) , rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }

    /**
     *
     * @param key
     * @return
     */
    public ArrayList<PermisoDTO> readAll_Rut(Object key) {
        ArrayList<PermisoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL_USUARIO);
            ps.setString(1, key.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new PermisoDTO(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5) , rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }

    /**
     *
     * @param key
     * @return
     */
    public ArrayList<PermisoDTO> readAll_Estado(Object key) {
        ArrayList<PermisoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL_ESTADO);
            ps.setString(1, key.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new PermisoDTO(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5) , rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }

    /**
     *
     * @param key
     * @return
     */
    public ArrayList<PermisoDTO> readAll_Departamento(Object key) {
        ArrayList<PermisoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL_DEPARTAMENTO);
            ps.setString(1, key.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new PermisoDTO(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5) , rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }

    /**
     *
     * @param key1
     * @param key2
     * @return
     */
    public ArrayList<PermisoDTO> readAll_Estado_Departamento(Object key1, Object key2) {
        ArrayList<PermisoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL_ESTADO_DEPARTAMENTO);
            ps.setString(1, key1.toString());
            ps.setString(2, key2.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new PermisoDTO(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5) , rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }

    /**
     *
     * @param key1
     * @param key2
     * @param key3
     * @return
     */
    public int sum_Usuario_Estado_Tipo(Object key1, Object key2, Object key3) {
        int entero = 0;
        try {
            ps = con.getCnn().prepareStatement(SQL_SUM_USUARIO_ESTADO_TIPO);
            ps.setString(1, key1.toString());
            ps.setString(2, key2.toString());
            ps.setString(3, key3.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entero = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entero;
    }

    /**
     *
     * @param key
     * @return
     */
    public PermisoDTO read_Resolucion(Object key) {
        PermisoDTO permiso = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ_RESOLUCION);
            ps.setString(1, key.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                permiso = new PermisoDTO(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getDate(5) , rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permiso;
    }
}
