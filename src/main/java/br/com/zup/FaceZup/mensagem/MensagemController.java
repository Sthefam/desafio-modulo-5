package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.mensagem.dtos.CadastrarMensagemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void cadastrarMensagem(@RequestBody @Valid CadastrarMensagemDTO mensagemDTO){
        mensagemService.cadastrarMensagem(mensagemDTO.getOrigem(), mensagemDTO.getDestino(), mensagemDTO.getMensagem());
    }

    @GetMapping("/id/{idMensagem}")
    public Mensagem exibirMensagem(@PathVariable int idMensagem){
        return mensagemService.exibirMensagem(idMensagem);
    }

}
