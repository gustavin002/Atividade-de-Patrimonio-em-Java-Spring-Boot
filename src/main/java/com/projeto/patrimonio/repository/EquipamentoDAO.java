/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.repository;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.model.EquipamentoDepartamentoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EquipamentoDAO {
    
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

            String sqlInsert = "INSERT INTO equipamento (codigo_patrimonio, tipo, marca, id_departamento) VALUES (?, ?, ?, ?)";
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
    
    public List<EquipamentoDepartamentoBean> listarEquipamentos(){
        List<EquipamentoDepartamentoBean> listar = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
         
            PreparedStatement stmt = null;
            ResultSet rs = null;
         
            stmt = conn.prepareStatement("SELECT id_equipamento, codigo_patrimonio, tipo, marca, nome, andar FROM equipamento AS e INNER JOIN departamento as d ON e.id_equipamento = d.id_departamento");
            rs = stmt.executeQuery();
         
            while(rs.next()){
                EquipamentoDepartamentoBean equipamento = new EquipamentoDepartamentoBean();
                equipamento.setIdEquipamento(rs.getInt("id_equipamento"));
                equipamento.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
                equipamento.setTipo(rs.getString("tipo"));
                equipamento.setMarca(rs.getString("marca"));
                equipamento.setNome(rs.getString("nome"));
                equipamento.setAndar(rs.getInt("andar"));
            
                listar.add(equipamento);
            }

        } catch (SQLException e){
             e.printStackTrace();
        }
         return listar;
         
    }
    
    public void editarEquipamentos(EquipamentoBean equipamento){
        try {
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("UPDATE equipamento SET tipo = ?, marca = ?, id_departamento = ? WHERE id_equipamento = ?");
            stmt.setString(1, equipamento.getTipo());
            stmt.setString(2, equipamento.getMarca());
            stmt.setInt(3, equipamento.getIdDepartamento());
            stmt.setInt(4, equipamento.getIdEquipamento());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
  
    public void excluirEquipamentos (int id){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("DELETE * FROM equipamento WHERE id = ?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public EquipamentoBean buscarPorEtiqueta(String codigo) {
    EquipamentoBean equipamento = null;
    try {
        Connection conn = Conexao.conectar();
        
        
        String sql = "SELECT * FROM equipamento WHERE codigo_patrimonio = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, codigo);
        
        ResultSet rs = stat.executeQuery();
        
 
        if (rs.next()) {
            equipamento = new EquipamentoBean();          
            equipamento.setIdEquipamento(rs.getInt("id_equipamento"));
            equipamento.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
            equipamento.setTipo(rs.getString("tipo"));
            equipamento.setMarca(rs.getString("marca"));
            equipamento.setIdDepartamento(rs.getInt("id_departamento"));
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return equipamento;
}
}