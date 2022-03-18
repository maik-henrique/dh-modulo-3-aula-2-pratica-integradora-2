package br.com.mercadolivre.dtopratica.repository;


import br.com.mercadolivre.dtopratica.entity.BaseEntity;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InMemoryRepository<T extends BaseEntity, U> implements Repository<T, U> {

    private List<T> elementos;
    private int counter;

    public InMemoryRepository() {
        this.elementos = new LinkedList<>();
        this.counter = 0;
    }

    @Override
    public void add(T elemento) {
        elemento.setId(counter);
        counter++;
        elementos.add(elemento);
    }

    @Override
    public Optional<T> findBy(U parametro) {
        return elementos.stream().filter(el -> el.comparaParametro(parametro)).findFirst();
    }

    @Override
    public List<T> findAll() {
        return elementos;
    }
}
