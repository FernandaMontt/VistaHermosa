/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import DTO.UsuarioPerTipoPermisoDTO;
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
public class PermisoTipoDAO {
    
    PreparedStatement ps;
    
    private static final String SQL_READ = "SELECT * FROM TIPO_PERMISO WHERE ID_PERMISO = ?";
    private static final String SQL_READALL = "SELECT * FROM TIPO_PERMISO";
    
    private static final Conexion con = Conexion.iniciarConexion();
    
    /**
     *
     * @param key
     * @return
     */
    public UsuarioPerTipoPermisoDTO read(Object key) {
        ResultSet rs;
        UsuarioPerTipoPermisoDTO permisoTipo = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                permisoTipo = new UsuarioPerTipoPermisoDTO(rs.getInt(1), rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPerTipoPermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permisoTipo;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<UsuarioPerTipoPermisoDTO> readAll() {
        ArrayList<UsuarioPerTipoPermisoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(new UsuarioPerTipoPermisoDTO(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPerTipoPermisoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoTipoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listado;
    }
}
