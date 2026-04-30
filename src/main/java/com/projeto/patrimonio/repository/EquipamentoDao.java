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
