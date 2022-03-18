package br.com.mercadolivre.dtopratica.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Esporte extends BaseEntity<String>{
    private String nome;
    private String nivel;

    @Override
    public boolean comparaParametro(String nome) {
        return this.nome.equalsIgnoreCase(nome);
    }
}
