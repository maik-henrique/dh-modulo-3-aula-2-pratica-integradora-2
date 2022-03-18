package br.com.mercadolivre.dtopratica.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pessoa extends BaseEntity<String> {
    private String nome;
    private String sobrenome;
    private int idade;
    private Esporte esporte;

    @Override
    public boolean comparaParametro(String parametro) {
        return nome.equalsIgnoreCase(parametro);
    }
}
