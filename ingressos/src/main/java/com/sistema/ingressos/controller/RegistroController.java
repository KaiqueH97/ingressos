package com.sistema.ingressos.controller;

import com.sistema.ingressos.entity.Registro;
import com.sistema.ingressos.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private RegistroService service;

    @GetMapping
    public List<Registro> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Registro buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Registro criarRegistro(@RequestBody Registro registro) {
        return service.salvar(registro);
    }

    @PutMapping("/{id}")
    public Registro atualizarRegistro(@PathVariable Long id, @RequestBody Registro registro) {
        return service.atualizar(id, registro);
    }

    @DeleteMapping("/{id}")
    public void deletarRegistro(@PathVariable Long id) {
        service.deletar(id);
    }
}