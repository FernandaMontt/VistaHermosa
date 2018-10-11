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
public class UsuarioCargoDTO {
    
    private int id_cargo;
    private String nombre;

    public UsuarioCargoDTO() {
    }

    public UsuarioCargoDTO(int id_cargo, String nombre) {
        this.id_cargo = id_cargo;
        this.nombre = nombre;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "UsuarioCargoDTO{" + "id_cargo=" + id_cargo + ", nombre=" + nombre + '}';
    }
    
    
}
