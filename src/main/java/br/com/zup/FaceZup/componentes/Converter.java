package br.com.zup.FaceZup.componentes;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
