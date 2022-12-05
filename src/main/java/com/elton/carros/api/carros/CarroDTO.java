package com.elton.carros.api.carros;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarroDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private String url_foto;
    private String url_video;
    private String latitude;
    private String longitude;

    public static CarroDTO create(Carro c) {
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(c, CarroDTO.class);
    }
}


