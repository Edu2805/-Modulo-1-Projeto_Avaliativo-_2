package com.devinhouse.devagro.models.dto.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    //O Model Mapper foi usado para fazer o "convert" entre uma determinada entidade e um DTO
    //Este método instancia o Model Mapper para ele ser usado no controller, onde serão envocados os end-points
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
