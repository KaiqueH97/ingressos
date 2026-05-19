package com.sistema.ingressos.controller;

import com.sistema.ingressos.entity.Usuario;
import com.sistema.ingressos.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios-html")
public class UsuarioHtmlController {

    @Autowired
    private UsuarioService service;

    // CREATE
    @PostMapping("/salvar")
    public String salvarUsuario(
            @RequestParam String nomeUsuario,
            @RequestParam String email,
            @RequestParam String telefone
    ) {
        Usuario usuario = new Usuario();
        
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);

        service.salvar(usuario);

        return "redirect:/usuarios.html";
    }

    // READ
    @GetMapping("/buscar")
    @ResponseBody
    public Usuario buscarUsuario(@RequestParam Long idUsuario) {
        return service.buscarPorId(idUsuario);
    }

    // UPDATE
    @PostMapping("/atualizar")
    public String atualizarUsuario(
            @RequestParam Long idUsuario,
            @RequestParam String nomeUsuario,
            @RequestParam String email,
            @RequestParam String telefone
    ) {
        Usuario usuario = new Usuario();
        
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);

        // Chama o método de atualizar que já criamos no UsuarioService
        service.atualizar(idUsuario, usuario);

        return "redirect:/usuarios.html";
    }

    // DELETE
    @PostMapping("/excluir")
    public String excluirUsuario(@RequestParam Long idUsuario) {
        service.deletar(idUsuario);

        return "redirect:/usuarios.html";
    }

    // LISTAR
    @GetMapping("/listar")
    @ResponseBody
    public List<Usuario> listarUsuarios() {
        return service.listarTodos();
    }
}