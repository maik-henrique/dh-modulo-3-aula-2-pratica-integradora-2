package br.com.mercadolivre.dtopratica.repository;


import java.util.List;
import java.util.Optional;


public interface Repository<T, U> {

    void add(T elemento);
    Optional<T> findBy(U parametro);
    List<T> findAll();
}
