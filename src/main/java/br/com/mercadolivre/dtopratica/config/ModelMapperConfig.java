package br.com.mercadolivre.dtopratica.config;

import br.com.mercadolivre.dtopratica.dto.AtletaDTO;
import br.com.mercadolivre.dtopratica.entity.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Pessoa.class, AtletaDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getEsporte().getNome(), AtletaDTO::setEsporte);
        });

        return modelMapper;
    }
}
