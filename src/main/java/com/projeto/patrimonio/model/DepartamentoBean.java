/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.model;

public class DepartamentoBean {

    private int idDepartamento;
    private String nome;
    private String andar;

    public DepartamentoBean() {
    }

    public DepartamentoBean(int idDepartamento, String nome, String andar) {
        this.idDepartamento = idDepartamento;
        this.nome = nome;
        this.andar = andar;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }
    
}
