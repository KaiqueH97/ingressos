package com.sistema.ingressos.controller;

import com.sistema.ingressos.entity.Principal;
import com.sistema.ingressos.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/principais")
public class PrincipalController {

    @Autowired
    private PrincipalService service;

    @GetMapping
    public List<Principal> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Principal buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Principal criarPrincipal(@RequestBody Principal principal) {
        return service.salvar(principal);
    }

    @PutMapping("/{id}")
    public Principal atualizarPrincipal(@PathVariable Long id, @RequestBody Principal principal) {
        return service.atualizar(id, principal);
    }

    @DeleteMapping("/{id}")
    public void deletarPrincipal(@PathVariable Long id) {
        service.deletar(id);
    }
}