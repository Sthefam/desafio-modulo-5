package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.mensagem.dtos.CadastrarMensagemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class MensagemController {
    private ModelMapper modelMapper;
    private MensagemService mensagemService;

    @Autowired
    public MensagemController(ModelMapper modelMapper, MensagemService mensagemService) {
        this.modelMapper = modelMapper;
        this.mensagemService = mensagemService;
    }

    @PostMapping
    public Mensagem cadastrarMensagem(@RequestBody CadastrarMensagemDTO mensagemDTO){
        return mensagemService.cadastrarMensagem(mensagemDTO.getOrigem(), mensagemDTO.getDestino(), mensagemDTO.getMensagem());
    }

}