/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.repository;

import com.projeto.patrimonio.model.DepartamentoBean;
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
public class DepartamentoDAO {
    public List<EquipamentoBean> lerDepartamento(int id) {
        List<EquipamentoBean> lista = new ArrayList();

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM equipamento WHERE id_departamento = ?");

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            EquipamentoBean equipamento = new EquipamentoBean();
            equipamento.setIdEquipamento(rs.getInt("id_equipamento"));
            equipamento.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
            equipamento.setTipo(rs.getString("tipo"));
            equipamento.setMarca(rs.getString("marca"));
            equipamento.setIdDepartamento(rs.getInt("id_departamento"));

            lista.add(equipamento);
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    
    }
    
    public List<EquipamentoDepartamentoBean> contarEquipamentoPorDepartamento() {
        List<EquipamentoDepartamentoBean> lista = new ArrayList();

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement("SELECT d.nome AS nome, COUNT(e.id_equipamento) AS total_equipamentos FROM equipamento e JOIN departamento d ON e.id_departamento = d.id_departamento GROUP BY d.nome;");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            EquipamentoDepartamentoBean equipamento = new EquipamentoDepartamentoBean();
            equipamento.setNome(rs.getString("nome"));
            equipamento.setTotalEquipamentos(rs.getInt("total_equipamentos"));

            lista.add(equipamento);
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    
    }
    
}
