/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.controller;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.model.EquipamentoDepartamentoBean;
import com.projeto.patrimonio.service.DepartamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoService service;
    
    @GetMapping("/departamentos/{id}/equipamentos")
    public List<EquipamentoBean> lerDepartamento(@PathVariable int id) {
        return service.lerDepartamento(id);
}
    
    @GetMapping("/relatorios/contagem-por-departamento")
    public List<EquipamentoDepartamentoBean> contarEquipamentoPorDepartamento(){
        return service.contarEquipamentoPorDepartamento();
    }
    
}
