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
public class UsuarioTipoContratoDTO {
    
    private int id_tipo_contrato;
    private String tipo_contrato;

    public UsuarioTipoContratoDTO() {
    }

    public UsuarioTipoContratoDTO(int id_tipo_contrato, String tipo_contrato) {
        this.id_tipo_contrato = id_tipo_contrato;
        this.tipo_contrato = tipo_contrato;
    }

    public int getId_tipo_contrato() {
        return id_tipo_contrato;
    }

    public void setId_tipo_contrato(int id_tipo_contrato) {
        this.id_tipo_contrato = id_tipo_contrato;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    @Override
    public String toString() {
        return "UsuarioTipoContratoDTO{" + "id_tipo_contrato=" + id_tipo_contrato + ", tipo_contrato=" + tipo_contrato + '}';
    }
    
    
}
