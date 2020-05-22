package io.github.gabrielstz120.services;

import io.github.gabrielstz120.models.Usuario;
import io.github.gabrielstz120.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        usuarioRepository.save(Usuario.builder()
                .nome("administrador")
                .email("admin")
                .senha("admin")
                .build());
    }

    public boolean login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            return usuario.getSenha().equals(senha);
        }
        return false;
    }

    public boolean salvar(Usuario usuario) {
        return usuarioRepository.save(usuario).getId() != null;
    }

}
