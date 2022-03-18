package br.com.mercadolivre.dtopratica.service;

import br.com.mercadolivre.dtopratica.entity.Esporte;
import br.com.mercadolivre.dtopratica.entity.Pessoa;
import br.com.mercadolivre.dtopratica.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {
    @Autowired
    private Repository<Esporte, String> esporteRepository;


    public void addEsporte(Esporte esporte) {
        esporteRepository.add(esporte);
    }

    public List<Esporte> findAll() {
        return esporteRepository.findAll();
    }

    public Optional<Esporte> findByNome(String nome) {
        return esporteRepository.findBy(nome);
    }

}
