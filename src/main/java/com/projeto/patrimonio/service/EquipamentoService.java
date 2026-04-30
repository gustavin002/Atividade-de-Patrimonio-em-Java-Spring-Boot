/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.service;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.repository.EquipamentoDao;
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
    
    public void editarEquipamentos(EquipamentoBean equipamento) {
        repository.editarEquipamentos(equipamento);
    }
}
