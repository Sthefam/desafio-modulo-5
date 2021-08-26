package br.com.zup.FaceZup.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarUsuarioPeloEmail(String email){
        Optional<Usuario> usuario = usuarioRepository.findById(email);
        if(usuario.isPresent()){
            return usuario.get();
        }
        throw new RuntimeException("Usuário não encontrado!");
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
