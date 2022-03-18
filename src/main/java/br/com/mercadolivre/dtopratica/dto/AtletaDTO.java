package br.com.mercadolivre.dtopratica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AtletaDTO {
    private String nome;
    private String sobrenome;
    private String esporte;
}
