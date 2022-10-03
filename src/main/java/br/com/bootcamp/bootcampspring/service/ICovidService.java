package br.com.bootcamp.bootcampspring.service;

import br.com.bootcamp.bootcampspring.model.Pessoa;
import br.com.bootcamp.bootcampspring.model.Sintoma;
import br.com.bootcamp.bootcampspring.until.NumberGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ICovidService implements br.com.bootcamp.bootcampspring.interfaces.ICovidService {
    List<Pessoa> pessoas = new ArrayList<>();
    List<Sintoma> sintomas = new ArrayList<>();

    NumberGenerator numberGenerator;

    public ICovidService() {
        numberGenerator = NumberGenerator.getInstance();
    }

    @Override
    public Pessoa criarPessoa(String nome, String sobrenome, int idade) {
        Pessoa pessoa = new Pessoa(numberGenerator.getNext(), nome, sobrenome, idade);

        pessoas.add(pessoa);

        return pessoa;
    }

    @Override
    public Sintoma adicionarSintoma( String codigo, String nome, String gravidade) {
        Sintoma sintoma = new Sintoma(numberGenerator.getNext(), nome, gravidade);
        sintomas.add(sintoma);

        return sintoma;
    }

    @Override
    public List<Sintoma> buscarSintomas(String nome) {
        if (!nome.isBlank())
            return sintomas.stream().filter(s -> s.getNome().equals(nome)).collect(Collectors.toList());

        return sintomas;
    }

    @Override
    public Pessoa vincularSintomaPessoa(int idPessoa, int idSintoma) {
        Sintoma sintoma = sintomas.stream()
                        .filter(s-> s.getCodigo()==idSintoma).findFirst().get();

        pessoas.stream().filter(p -> p.getID()==idPessoa).findFirst().get().getSintomas().add(sintoma);

        Pessoa pessoa = pessoas.stream().filter(p -> p.getID()==idPessoa).findFirst().get();

        return pessoa;
    }

    @Override
    public List<Pessoa> grupoDeRisco() {
        return pessoas.stream().filter(p-> p.getIdade() > 60 || p.getSintomas().size() > 0).collect(Collectors.toList());
    }
}
