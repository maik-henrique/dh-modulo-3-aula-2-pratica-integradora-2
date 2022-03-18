package br.com.mercadolivre.dtopratica.entity;

import lombok.Data;

@Data
public abstract class BaseEntity<T> {
    private Integer id;

    public abstract boolean comparaParametro(T parametro);
}
