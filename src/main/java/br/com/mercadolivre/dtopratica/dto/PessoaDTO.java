package br.com.mercadolivre.dtopratica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private String nome;
    private String sobrenome;
    private int idade;
}
