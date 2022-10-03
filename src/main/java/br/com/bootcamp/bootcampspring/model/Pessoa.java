package br.com.bootcamp.bootcampspring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pessoa {
    private int ID;
    private String nome;
    private String sobrenome;
    private int idade;
    private List<Sintoma> sintomas;

    public Pessoa(int ID, String nome, String sobrenome, int idade) {
        this.ID = ID;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }
}
