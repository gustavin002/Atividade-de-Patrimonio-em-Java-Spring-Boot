/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.controller;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {
    
    @Autowired
    private EquipamentoService equipamentoService;
    
    @PutMapping("/{id}")
    public String editarEquipamentos(@PathVariable int id, @RequestBody EquipamentoBean equipamento) {
        equipamento.setIdEquipamento(id);

        equipamentoService.editarEquipamentos(equipamento);
        return "Equipamento atualizado com sucesso!";
    }
}
