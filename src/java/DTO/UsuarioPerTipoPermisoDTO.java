/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author note
 */
public class UsuarioPerTipoPermisoDTO {
    
    private int id_permiso;
    private String permiso;

    public UsuarioPerTipoPermisoDTO() {
    }

    public UsuarioPerTipoPermisoDTO(int id_permiso, String permiso) {
        this.id_permiso = id_permiso;
        this.permiso = permiso;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public String toString() {
        return "UsuarioTipoPermisoDTO{" + "id_permiso=" + id_permiso + ", permiso=" + permiso + '}';
    }
    
    
}
