/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.model;

/**
 *
 * @author Aluno
 */
public class EquipamentoBean {
    private int idEquipamento;
    private String codigoPatrimonio;
    private String tipo;
    private String marca;
    private int idDepartamento;

    public EquipamentoBean() {
    }

    public EquipamentoBean(int idEquipamento, String codigoPatrimonio, String tipo, String marca, int idDepartamento) {
        this.idEquipamento = idEquipamento;
        this.codigoPatrimonio = codigoPatrimonio;
        this.tipo = tipo;
        this.marca = marca;
        this.idDepartamento = idDepartamento;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getCodigoPatrimonio() {
        return codigoPatrimonio;
    }

    public void setCodigoPatrimonio(String codigoPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
}
