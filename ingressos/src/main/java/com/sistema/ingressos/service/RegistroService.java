package com.sistema.ingressos.service;

import com.sistema.ingressos.entity.Registro;
import com.sistema.ingressos.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository repository;

    public List<Registro> listarTodos() {
        return repository.findAll();
    }

    public Registro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro da compra não encontrado"));
    }

    public Registro salvar(Registro registro) {
        return repository.save(registro);
    }

    public Registro atualizar(Long id, Registro registro) {
        Registro existente = buscarPorId(id);

        existente.setUsuario(registro.getUsuario());
        existente.setDataRegistro(registro.getDataRegistro());
        existente.setStatus(registro.getStatus());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}