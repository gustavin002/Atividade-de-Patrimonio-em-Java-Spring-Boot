/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.repository;

import com.projeto.patrimonio.model.EquipamentoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository 
public class EquipamentoDao {
    public void editarEquipamentos(EquipamentoBean equipamento) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("UPDATE equipamento SET tipo=?, marca=? WHERE id_equipamento=?");
            stmt.setString(1, equipamento.getTipo());
            stmt.setString(2, equipamento.getMarca());
            stmt.setInt(3, equipamento.getIdEquipamento());
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
