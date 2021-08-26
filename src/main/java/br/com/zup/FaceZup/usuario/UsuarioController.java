package br.com.zup.FaceZup.usuario;

import br.com.zup.FaceZup.mensagem.Mensagem;
import br.com.zup.FaceZup.mensagem.dtos.MensagensIdsDTO;
import br.com.zup.FaceZup.mensagem.dtos.MensagensNaoLidasDTO;
import br.com.zup.FaceZup.usuario.dtos.CadastrarUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {
    private UsuarioService usuarioService;
    private ModelMapper modelMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, ModelMapper modelMapper) {
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/usuario")
    public Usuario cadastrarUsuario(@RequestBody CadastrarUsuarioDTO usuarioDTO){
        return usuarioService.cadastrarUsuario(modelMapper.map(usuarioDTO,Usuario.class));
    }

    @GetMapping("/usuario/perfil/{emailUsuario}")
    public MensagensNaoLidasDTO filtrarPorMensagensNaoLidas(@PathVariable String emailUsuario){
        List<Mensagem> mensagens = usuarioService.filtrarPorMensagensNaoLidas(emailUsuario);

        return new MensagensNaoLidasDTO(mensagens.size(),mensagens.stream().map(mensagem -> new MensagensIdsDTO(mensagem.getId())).collect(Collectors.toList()));
    }

}
