package br.com.zup.FaceZup.mensagem;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Mensagem cadastrarMensagem(@RequestBody ){

    }

}
