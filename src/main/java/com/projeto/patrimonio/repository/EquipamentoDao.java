/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.repository;

import com.projeto.patrimonio.model.EquipamentoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class EquipamentoDao {
    public List<EquipamentoBean> lerTodos(){
        List<EquipamentoBean> dados = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM equipamento ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
               EquipamentoBean equipamento = new EquipamentoBean();
                equipamento.setIdEquipamento(rs.getInt("id_equipamento"));
                equipamento.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
                equipamento.setTipo(rs.getString("tipo"));
                equipamento.setMarca(rs.getString("marca"));
               
                
                dados.add(equipamento);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
         return dados;   
    }
    
    
    
    public void criar(EquipamentoBean equipamento) {
    try {
        Connection conn = Conexao.conectar();
 
        String sqlCheck = "SELECT * FROM departamentos WHERE id = ?";
        PreparedStatement statCheck = conn.prepareStatement(sqlCheck);
        statCheck.setInt(1, equipamento.getIdDepartamento());
        ResultSet rs = statCheck.executeQuery();

        if (!rs.next()) {
            System.out.println("Erro: o departamento é inválido.");
            return; 
        }

      
        String sqlInsert = "INSERT INTO itens (codigo_patrimonio, tipo, marca, id_departamento) VALUES (?, ?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(sqlInsert);
        stat.setString(1, equipamento.getCodigoPatrimonio());
        stat.setString(2, equipamento.getTipo());
        stat.setString(3, equipamento.getMarca());
        stat.setInt(4, equipamento.getIdDepartamento());

        stat.executeUpdate();
        System.out.println("Equipamento cadastrado com sucesso!");

    } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    public void editarEquipamentos(EquipamentoBean equipamento){
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("UPDATE equipamento SET id_departamento=?, tipo=?, marca=? WHERE id_equipamento=?");
            stmt.setInt(1, equipamento.getIdDepartamento());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getMarca());
            stmt.setInt(4, equipamento.getIdEquipamento());
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}