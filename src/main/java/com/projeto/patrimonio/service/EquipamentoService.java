/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.service;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.repository.EquipamentoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class EquipamentoService {
    
    @Autowired
    private EquipamentoDao repository;
    
    public List<EquipamentoBean> lerTodos(){
      return repository.lerTodos();
    }
    
    public void adicionar(EquipamentoBean equipamento){
        repository.criar(equipamento);
    public void editarEquipamentos(EquipamentoBean equipamento) {
        repository.editarEquipamentos(equipamento);
    }
}
    

