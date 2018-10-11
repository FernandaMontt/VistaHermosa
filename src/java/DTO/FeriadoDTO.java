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
public class FeriadoDTO {
    
    private int id_feriado;
    private int dia;
    private int mes;
    private String descripcion;

    public FeriadoDTO() {
    }

    public FeriadoDTO(int id_feriado, int dia, int mes, String descripcion) {
        this.id_feriado = id_feriado;
        this.dia = dia;
        this.mes = mes;
        this.descripcion = descripcion;
    }

    public int getId_feriado() {
        return id_feriado;
    }

    public void setId_feriado(int id_feriado) {
        this.id_feriado = id_feriado;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "FeriadoDTO{" + "id_feriado=" + id_feriado + ", dia=" + dia + ", mes=" + mes + ", descripcion=" + descripcion + '}';
    }
    
    
}
