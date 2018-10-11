/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import DTO.PermisoMotivoDTO;
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
public class PermisoMotivoDAO {
    
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO MOTIVO VALUES (SEQ_MOTIVO.NEXTVAL, ?)";
    private static final String SQL_READ = "SELECT * FROM MOTIVO WHERE ID_MOTIVO = ?";
    private static final String SQL_READALL = "SELECT * FROM MOTIVO";
    
    private static final String SQL_LAST = "SELECT * FROM MOTIVO WHERE ID_MOTIVO = (SELECT MAX(ID_MOTIVO) FROM MOTIVO)";
    
    private static final Conexion con = Conexion.iniciarConexion();
    
    /**
     *
     * @param aux
     * @return
     */
    public boolean create(PermisoMotivoDTO aux) {
        try {          
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, aux.getMotivo());
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
                Logger.getLogger(PermisoMotivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    /**
     *
     * @param key
     * @return
     */
    public PermisoMotivoDTO read(Object key) {
        ResultSet rs;
        PermisoMotivoDTO permisoTipo = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                permisoTipo = new PermisoMotivoDTO(rs.getInt(1), rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoMotivoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoMotivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permisoTipo;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<PermisoMotivoDTO> readAll() {
        ArrayList<PermisoMotivoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new PermisoMotivoDTO(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoMotivoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoMotivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }
    
    /**
     *
     * @return
     */
    public PermisoMotivoDTO last() {
        ResultSet rs;
        PermisoMotivoDTO permisoTipo = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_LAST);
            rs = ps.executeQuery();
            while (rs.next()) {
                permisoTipo = new PermisoMotivoDTO(rs.getInt(1), rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PermisoMotivoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoMotivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permisoTipo;
    }
}
