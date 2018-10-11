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
import java.util.Date;

public class PermisoDTO {
    
    private int id_solicitud;
    private Date fecha_inicio;
    private Date fecha_termino;
    private Date fecha_reincorporacion;
    private Date fecha_solicitud;
    private Date fecha_revision;
    private int id_motivo;
    private int id_usuario;
    private int id_tipo_permiso;
    private int id_estado_permiso;

    public PermisoDTO() {
    }

    public PermisoDTO(int id_solicitud, Date fecha_inicio, Date fecha_termino, Date fecha_reincorporacion, Date fecha_solicitud, Date fecha_revision, int id_motivo, int id_usuario, int id_tipo_permiso, int id_estado_permiso) {
        this.id_solicitud = id_solicitud;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.fecha_reincorporacion = fecha_reincorporacion;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_revision = fecha_revision;
        this.id_motivo = id_motivo;
        this.id_usuario = id_usuario;
        this.id_tipo_permiso = id_tipo_permiso;
        this.id_estado_permiso = id_estado_permiso;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Date getFecha_reincorporacion() {
        return fecha_reincorporacion;
    }

    public void setFecha_reincorporacion(Date fecha_reincorporacion) {
        this.fecha_reincorporacion = fecha_reincorporacion;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Date getFecha_revision() {
        return fecha_revision;
    }

    public void setFecha_revision(Date fecha_revision) {
        this.fecha_revision = fecha_revision;
    }

    public int getId_motivo() {
        return id_motivo;
    }

    public void setId_motivo(int id_motivo) {
        this.id_motivo = id_motivo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tipo_permiso() {
        return id_tipo_permiso;
    }

    public void setId_tipo_permiso(int id_tipo_permiso) {
        this.id_tipo_permiso = id_tipo_permiso;
    }

    public int getId_estado_permiso() {
        return id_estado_permiso;
    }

    public void setId_estado_permiso(int id_estado_permiso) {
        this.id_estado_permiso = id_estado_permiso;
    }

    @Override
    public String toString() {
        return "PermisoDTO{" + "id_solicitud=" + id_solicitud + ", fecha_inicio=" + fecha_inicio + ", fecha_termino=" + fecha_termino + ", fecha_reincorporacion=" + fecha_reincorporacion + ", fecha_solicitud=" + fecha_solicitud + ", fecha_revision=" + fecha_revision + ", id_motivo=" + id_motivo + ", id_usuario=" + id_usuario + ", id_tipo_permiso=" + id_tipo_permiso + ", id_estado_permiso=" + id_estado_permiso + '}';
    }
    
    
    
}
