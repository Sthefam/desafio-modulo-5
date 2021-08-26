package br.com.zup.FaceZup.mensagem;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensagemRepository extends CrudRepository<Mensagem, Integer>{

    int countByVisualizadoFalseAndOrigemEmailContains(String email);

    List<Mensagem> findByVisualizadoFalseAndDestinoEmailContains(String email);

}
