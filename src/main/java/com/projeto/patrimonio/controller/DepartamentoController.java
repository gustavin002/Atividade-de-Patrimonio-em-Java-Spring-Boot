/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.controller;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.service.DepartamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoService service;
    
    @GetMapping("/{id}/equipamentos") //rota postman:http://localhost:9000/api/departamentos/1/equipamentos
    public List<EquipamentoBean> lerDepartamento(@PathVariable int id) {
        return service.lerDepartamento(id);
}
    
}
