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
public class UsuarioDTO {
   
    private int id_usuario;
    private String rut;
    private String nombre;
    private String apellido;
    private String usuario;
    private String pass;
    private String correo_empresa;
    private int f_legal;
    private int p_administrativo;
    private int p_parental;
    private int p_fallecimiento;
    private int anios_trabajados;
    private int id_asistencia;
    private int id_tipo_contrato;
    private int id_perfil;
    private int id_cargo;
    private int id_departamento;
    
    public UsuarioDTO() {
    }

    public UsuarioDTO(int id_usuario, String rut, String nombre, String apellido, String usuario, String pass, String correo_empresa, int f_legal, int p_administrativo, int p_parental, int p_fallecimiento, int anios_trabajados, int id_asistencia, int id_tipo_contrato, int id_perfil, int id_cargo, int id_departamento) {
        this.id_usuario = id_usuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.pass = pass;
        this.correo_empresa = correo_empresa;
        this.f_legal = f_legal;
        this.p_administrativo = p_administrativo;
        this.p_parental = p_parental;
        this.p_fallecimiento = p_fallecimiento;
        this.anios_trabajados = anios_trabajados;
        this.id_asistencia = id_asistencia;
        this.id_tipo_contrato = id_tipo_contrato;
        this.id_perfil = id_perfil;
        this.id_cargo = id_cargo;
        this.id_departamento = id_departamento;
    }
    
      
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo_empresa() {
        return correo_empresa;
    }

    public void setCorreo_empresa(String correo_empresa) {
        this.correo_empresa = correo_empresa;
    }

    public int getF_legal() {
        return f_legal;
    }

    public void setF_legal(int f_legal) {
        this.f_legal = f_legal;
    }

    public int getP_administrativo() {
        return p_administrativo;
    }

    public void setP_administrativo(int p_administrativo) {
        this.p_administrativo = p_administrativo;
    }

    public int getP_parental() {
        return p_parental;
    }

    public void setP_parental(int p_parental) {
        this.p_parental = p_parental;
    }

    public int getP_fallecimiento() {
        return p_fallecimiento;
    }

    public void setP_fallecimiento(int p_fallecimiento) {
        this.p_fallecimiento = p_fallecimiento;
    }

    public int getAnios_trabajados() {
        return anios_trabajados;
    }

    public void setAnios_trabajados(int anios_trabajados) {
        this.anios_trabajados = anios_trabajados;
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public int getId_tipo_contrato() {
        return id_tipo_contrato;
    }

    public void setId_tipo_contrato(int id_tipo_contrato) {
        this.id_tipo_contrato = id_tipo_contrato;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id_usuario=" + id_usuario + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", pass=" + pass + ", correo_empresa=" + correo_empresa + ", f_legal=" + f_legal + ", p_administrativo=" + p_administrativo + ", p_parental=" + p_parental + ", p_fallecimiento=" + p_fallecimiento + ", anios_trabajados=" + anios_trabajados + ", id_asistencia=" + id_asistencia + ", id_tipo_contrato=" + id_tipo_contrato + ", id_perfil=" + id_perfil + ", id_cargo=" + id_cargo + ", id_departamento=" + id_departamento + '}';
    }
    
    
    
}
