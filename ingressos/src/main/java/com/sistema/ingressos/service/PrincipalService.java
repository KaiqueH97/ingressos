package com.sistema.ingressos.service;

import com.sistema.ingressos.entity.Principal;
import com.sistema.ingressos.repository.PrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrincipalService {

    @Autowired
    private PrincipalRepository repository;

    public List<Principal> listarTodos() {
        return repository.findAll();
    }

    public Principal buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro Principal não encontrado"));
    }

    public Principal salvar(Principal principal) {
        return repository.save(principal);
    }

    public Principal atualizar(Long id, Principal principal) {
        Principal existente = buscarPorId(id);

        existente.setNome(principal.getNome());
        existente.setDescricao(principal.getDescricao());
        existente.setDataCadastro(principal.getDataCadastro());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
