/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import DTO.PermisoResolucionDTO;
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
public class PermisoResolucionDAO {
    
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO RESOLUCION (ID_RESOLUCION, FECHA_RESOLUCION, ID_SOLICITUD) VALUES (SEQ_RESOLUCIONES.NEXTVAL, ?, ?, ?)";
    private static final String SQL_READ = "SELECT *  FROM RESOLUCION WHERE ID_RESOLUCION = ?";
    private static final String SQL_READALL = "SELECT * FROM RESOLUCION";
    
    private static final String SQL_LAST = "SELECT * FROM RESOLUCION WHERE ID_RESOLUCION = (SELECT MAX(ID_RESOLUCION) FROM RESOLUCION)";
    
    private static final Conexion con = Conexion.iniciarConexion();
    
    /**
     *
     * @param aux
     * @return
     */
    public boolean create(PermisoResolucionDTO aux) {
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            
            ps.setInt(1, aux.getId_resolucion());
            ps.setDate(2, new java.sql.Date(aux.getFecha_resolucion().getTime()));
            ps.setInt(3, aux.getId_solicitud());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoResolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoResolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    /**
     *
     * @param key
     * @return
     */
    public PermisoResolucionDTO read(Object key) {
        ResultSet rs;
        PermisoResolucionDTO permisoResolucion = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                permisoResolucion = new PermisoResolucionDTO(rs.getInt(1), rs.getDate(2), rs.getInt(3));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoResolucionDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoResolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permisoResolucion;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<PermisoResolucionDTO> readAll() {
        ArrayList<PermisoResolucionDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new PermisoResolucionDTO(rs.getInt(1), rs.getDate(2), rs.getInt(3)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoResolucionDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoResolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }
    
    /**
     *
     * @return
     */
    public PermisoResolucionDTO last() {
        ResultSet rs;
        PermisoResolucionDTO permisoResolucion = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_LAST);
            rs = ps.executeQuery();
            while (rs.next()) {
                permisoResolucion = new PermisoResolucionDTO(rs.getInt(1), rs.getDate(2), rs.getInt(3));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoResolucionDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoResolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permisoResolucion;
    }
}
