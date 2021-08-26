package br.com.zup.FaceZup.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarUsuarioPeloEmail(String email){
        Usuario usuario = usuarioRepository.findUsuarioBy(email);
        if(usuario != null){
            return usuario;
        }
        throw new RuntimeException("Usuário não encontrado!");
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
