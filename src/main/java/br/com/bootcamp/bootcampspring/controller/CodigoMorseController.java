package br.com.bootcamp.bootcampspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/morse")
public class CodigoMorseController {

    @GetMapping("/{codigo}")
    public String getCodigoConvertido(@PathVariable String codigo){
        return "Texto traduzido: " + traduzirCodigoMorse(codigo);
    }

    private String traduzirCodigoMorse(String codigo){
        Map<String, String> dicionario = gerarDicionario();
        String traducao = "";

        String[] caracteres = codigo.split(" ");
        for(int i = 0; i < caracteres.length; i++)
        {
            traducao += dicionario.get(caracteres[i]);
        }

        return traducao;
    }

    private Map<String, String> gerarDicionario(){
        Map<String, String> alfabeto = new HashMap<>();

        alfabeto.put(".-", "a");
        alfabeto.put("-...", "b");
        alfabeto.put("-.-.", "c");
        alfabeto.put("-..", "d");
        alfabeto.put(".", "e");
        alfabeto.put("..-.", "f");
        alfabeto.put("--.", "g");
        alfabeto.put("....", "h");
        alfabeto.put("..", "i");
        alfabeto.put(".---", "j");
        alfabeto.put("-.-", "k");
        alfabeto.put(".-..", "l");
        alfabeto.put("--", "m");
        alfabeto.put("-.", "n");
        alfabeto.put("---", "o");
        alfabeto.put(".--.", "p");
        alfabeto.put("--.-", "q");
        alfabeto.put(".-.", "r");
        alfabeto.put("...", "s");
        alfabeto.put("-", "t");
        alfabeto.put("..-", "u");
        alfabeto.put("...-", "v");
        alfabeto.put(".--", "w");
        alfabeto.put("-..-", "x");
        alfabeto.put("-.--", "y");
        alfabeto.put("--..", "z");

        alfabeto.put(".----", "1");
        alfabeto.put("..---", "2");
        alfabeto.put("...--", "3");
        alfabeto.put("....-", "4");
        alfabeto.put(".....", "5");
        alfabeto.put("-....", "6");
        alfabeto.put("--...", "7");
        alfabeto.put("---..", "8");
        alfabeto.put("----.", "9");
        alfabeto.put("-----", "0");


        alfabeto.put("--..--", ",");
        alfabeto.put(".-.-.-", ".");
        alfabeto.put("..--..", "?");
        alfabeto.put("-.-.--", "!");
        alfabeto.put(" ", " ");

        return alfabeto;
    }
}
