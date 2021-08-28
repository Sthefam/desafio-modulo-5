package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.mensagem.dtos.CadastrarMensagemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarMensagem(@RequestBody CadastrarMensagemDTO mensagemDTO){
        mensagemService.cadastrarMensagem(mensagemDTO.getOrigem(), mensagemDTO.getDestino(), mensagemDTO.getMensagem());
    }

    @GetMapping
    public Mensagem exibirMensagem(@RequestParam(required = false) int id){
        return mensagemService.exibirMensagem(id);
    }

}
