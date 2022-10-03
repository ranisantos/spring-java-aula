package br.com.bootcamp.bootcampspring.controller;

import br.com.bootcamp.bootcampspring.interfaces.ICovidService;
import br.com.bootcamp.bootcampspring.model.Pessoa;
import br.com.bootcamp.bootcampspring.model.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {
    @Autowired
    private ICovidService service;

    @PostMapping()
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        return new ResponseEntity<Pessoa>(service.criarPessoa(pessoa.getNome(), pessoa.getSobrenome(), pessoa.getIdade()), HttpStatus.CREATED);
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getSintomaas(){
        return new ResponseEntity<List<Sintoma>>(service.buscarSintomas(""), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> getSintomaByName(@PathVariable String name){
        return new ResponseEntity<Sintoma>(service.buscarSintomas(name).stream().findFirst().get(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Pessoa>> getPessoasRisco(){
        return new ResponseEntity<List<Pessoa>>(service.grupoDeRisco(), HttpStatus.OK);
    }
}
