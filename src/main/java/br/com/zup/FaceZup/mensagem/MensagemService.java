package br.com.zup.FaceZup.mensagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    @Autowired
    private MensagemRepository mensagemRepository;

}
