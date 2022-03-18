package br.com.mercadolivre.dtopratica.controller;

import br.com.mercadolivre.dtopratica.dto.AtletaDTO;
import br.com.mercadolivre.dtopratica.dto.EsporteDTO;
import br.com.mercadolivre.dtopratica.dto.EsporteNivelDTO;
import br.com.mercadolivre.dtopratica.dto.PessoaDTO;
import br.com.mercadolivre.dtopratica.entity.Esporte;
import br.com.mercadolivre.dtopratica.entity.Pessoa;
import br.com.mercadolivre.dtopratica.service.PessoaService;
import br.com.mercadolivre.dtopratica.service.SportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SportController {

    private final PessoaService pessoaService;
    private final SportService esporteService;
    private final ModelMapper modelMapper;

    @Autowired
    public SportController(PessoaService pessoaService, SportService esporteService, ModelMapper modelMapper) {
        this.pessoaService = pessoaService;
        this.esporteService = esporteService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/esportes")
    public ResponseEntity<?> findSports() {
        return ResponseEntity.ok(esporteService.findAll());
    }

    @GetMapping("/esportes/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name) {
        Optional<Esporte> esporte = esporteService.findByNome(name);

        if (esporte.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        EsporteNivelDTO esporteNivelDTO = modelMapper.map(esporte.get(), EsporteNivelDTO.class);
        return ResponseEntity.ok(esporteNivelDTO);
    }

    @GetMapping("/pessoas/findSportPeople")
    public ResponseEntity<?> findSportPeople() {
        List<Pessoa> pessoas = pessoaService.findAll();
        List<AtletaDTO> atletas = pessoas.stream().map(pessoa -> modelMapper.map(pessoa, AtletaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(atletas);
    }

    @PostMapping("/esportes")
    public ResponseEntity<?> saveEsporte(@RequestBody EsporteDTO esporte) {
        Esporte esporteEntity = modelMapper.map(esporte, Esporte.class);
        esporteService.addEsporte(esporteEntity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/pessoas")
    public ResponseEntity<?> savePessoa(@RequestBody PessoaDTO pessoa) {
        Pessoa pessoaEntity = modelMapper.map(pessoa, Pessoa.class);
        pessoaService.addPessoa(pessoaEntity);
        return ResponseEntity.ok().build();
    }


}
