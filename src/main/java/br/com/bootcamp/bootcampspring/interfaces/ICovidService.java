package br.com.bootcamp.bootcampspring.interfaces;

import br.com.bootcamp.bootcampspring.model.Pessoa;
import br.com.bootcamp.bootcampspring.model.Sintoma;

import java.util.List;

public interface ICovidService {
    public Pessoa criarPessoa(String nome, String sobrenome, int idade);
    public Sintoma adicionarSintoma(String codigo, String nome, String gravidade);
    public List<Sintoma> buscarSintomas(String nome);

    public Pessoa vincularSintomaPessoa(int idPessoa, int idSintoma);
    public List<Pessoa> grupoDeRisco();
}
