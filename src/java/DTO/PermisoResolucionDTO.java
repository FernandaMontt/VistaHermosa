/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author note
 */
public class PermisoResolucionDTO {
    
    private int id_resolucion;
    private Date fecha_resolucion;
    private int id_solicitud;

    public PermisoResolucionDTO() {
    }

    public PermisoResolucionDTO(int id_resolucion, Date fecha_resolucion, int id_solicitud) {
        this.id_resolucion = id_resolucion;
        this.fecha_resolucion = fecha_resolucion;
        this.id_solicitud = id_solicitud;
    }

    public int getId_resolucion() {
        return id_resolucion;
    }

    public void setId_resolucion(int id_resolucion) {
        this.id_resolucion = id_resolucion;
    }

    public Date getFecha_resolucion() {
        return fecha_resolucion;
    }

    public void setFecha_resolucion(Date fecha_resolucion) {
        this.fecha_resolucion = fecha_resolucion;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    @Override
    public String toString() {
        return "PermisoResolucionDTO{" + "id_resolucion=" + id_resolucion + ", fecha_resolucion=" + fecha_resolucion + ", id_solicitud=" + id_solicitud + '}';
    }
    
    
}
