/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.patrimonio.service;

import com.projeto.patrimonio.model.EquipamentoBean;
import com.projeto.patrimonio.repository.DepartamentoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class DepartamentoService {
    
    @Autowired
    private DepartamentoDao repository;
    
    public List<EquipamentoBean> lerDepartamento(int id) {
        return repository.lerDepartamento(id);
    }
}
