package br.com.mercadolivre.dtopratica.service;

import br.com.mercadolivre.dtopratica.entity.Pessoa;
import br.com.mercadolivre.dtopratica.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private Repository<Pessoa, String> pessoaRepository;

    public void addPessoa(Pessoa pessoa) {
        pessoaRepository.add(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
}
