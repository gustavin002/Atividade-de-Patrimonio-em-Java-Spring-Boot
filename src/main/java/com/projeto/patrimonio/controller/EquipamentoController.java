/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.controller;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.repository.EquipamentoDao;
import com.projeto.patrimonio.service.EquipamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService service; 

    @GetMapping("/lertodos")
    public List<EquipamentoBean> lerTodos() {
        return service.lerTodos();
    }

   @PostMapping("/criar")
public String adicionar(@RequestBody EquipamentoBean equipamento) {
    service.adicionar(equipamento);
    return "Cadastrado com sucesso!";
    }
    
    @PutMapping("/{id}")
    public String editarEquipamentos(@PathVariable int id, @RequestBody EquipamentoBean equipamento) {
        equipamento.setIdEquipamento(id);

        service.editarEquipamentos(equipamento);
        return "Equipamento atualizado com sucesso!";
    }
}
