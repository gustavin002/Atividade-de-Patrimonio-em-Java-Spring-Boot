/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.controller;
import com.projeto.patrimonio.model.PatrimonioBean;
import com.projeto.patrimonio.service.EquipamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipamentoController {
    
    @Autowired
    private EquipamentoService service;
    
    @GetMapping("/api/equipamentos")
    public List<PatrimonioBean> listarEquipamentos(){
        return service.listar();
    }
    
}
