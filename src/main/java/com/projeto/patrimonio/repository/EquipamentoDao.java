/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.repository;

import com.projeto.patrimonio.model.PatrimonioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EquipamentoDAO {
    
     public List<PatrimonioBean> listarEquipamentos(){
        List<PatrimonioBean> listar = new ArrayList();
         
        try{
         
        Connection conn = Conexao.conectar();
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
         
        stmt = conn.prepareStatement("SELECT id_equipamento, codigo_patrimonio, tipo, marca, nome, andar FROM equipamento AS e INNER JOIN departamento as d ON e.id_equipamento = d.id_departamento");
         
        rs = stmt.executeQuery();
         
        while(rs.next()){
            PatrimonioBean equipamento = new PatrimonioBean();
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
}
