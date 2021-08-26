package br.com.zup.FaceZup.usuario;

import br.com.zup.FaceZup.usuario.dtos.CadastrarUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;
    private ModelMapper modelMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, ModelMapper modelMapper) {
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody CadastrarUsuarioDTO usuarioDTO){
        return usuarioService.cadastrarUsuario(modelMapper.map(usuarioDTO,Usuario.class));
    }
}
