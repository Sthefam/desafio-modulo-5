package br.com.zup.FaceZup.usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
    Usuario findUsuarioBy(String email);
}
