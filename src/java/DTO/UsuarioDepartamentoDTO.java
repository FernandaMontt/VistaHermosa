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
public class UsuarioDepartamentoDTO {
    
    private int id_departamento;
    private String nombre;

    public UsuarioDepartamentoDTO() {
    }

    public UsuarioDepartamentoDTO(int id_departamento, String nombre) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "UsuarioDepartamentoDTO{" + "id_departamento=" + id_departamento + ", nombre=" + nombre + '}';
    }
    
    
    
}
