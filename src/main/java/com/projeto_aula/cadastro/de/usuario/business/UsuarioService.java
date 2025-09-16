package com.projeto_aula.cadastro.de.usuario.business;

import com.projeto_aula.cadastro.de.usuario.infrastructure.entitys.Usuario;
import com.projeto_aula.cadastro.de.usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import static com.projeto_aula.cadastro.de.usuario.infrastructure.entitys.Usuario.*;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarUsuario(Usuario usuario, String email) {
        Usuario usuarioEntity = repository.findUserByEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .id(usuarioEntity.getId())
                .email(usuarioEntity.getEmail() != null ? usuarioEntity.getEmail() : usuario.getEmail())
                .name(usuario.getName() != null ? usuario.getName() : usuarioEntity.getName())
                .senha(usuario.getSenha() != null ? usuario.getSenha() : usuarioEntity.getSenha())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
