/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.service;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.model.EquipamentoDepartamentoBean;
import com.projeto.patrimonio.repository.EquipamentoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {
    
    @Autowired
    private EquipamentoDAO repository;
    
    public List<EquipamentoDepartamentoBean> listarEquipamentos(){
      return repository.listarEquipamentos();
    }
     
    public void criar(EquipamentoBean equipamento){
        repository.criar(equipamento);
    }
    
    public void editarEquipamentos(EquipamentoBean equipamento) {
        repository.editarEquipamentos(equipamento);
    }
    
    public void excluirEquipamentos(int id){
        repository.excluirEquipamentos(id);
    }
    
}
