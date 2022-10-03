package br.com.bootcamp.bootcampspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private int codigo;
    private String nome;
    private String nivel_de_gravidade;
}
