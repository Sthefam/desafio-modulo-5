package br.com.zup.FaceZup.componentes;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
