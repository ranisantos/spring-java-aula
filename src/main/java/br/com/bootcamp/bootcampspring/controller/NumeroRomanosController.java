package br.com.bootcamp.bootcampspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romanos")
public class NumeroRomanosController {

    @GetMapping("/{numero}")
    public String getNumeroConvertido(@PathVariable int numero){
        return "Numero convertido= " + converterNumer(numero);
    }

    private String converterNumer(int numero){
        int i, milhares, centenas, dezenas, unidades;
        String numeroRomano = "";

        milhares = numero / 1000;
        centenas = numero / 100 % 10;
        dezenas = numero / 10 % 10;
        unidades = numero % 10;

        for (i = 1; i <= milhares; i++) {
            numeroRomano = numeroRomano + "M";
        }

        if (centenas == 9) {
            numeroRomano = numeroRomano + "CM";
        } else if (centenas >= 5) {
            numeroRomano = numeroRomano + "D";
            for (i = 6; i <= centenas; i++) {
                numeroRomano = numeroRomano + "C";
            }
        } else if (centenas == 4) {
            numeroRomano = numeroRomano + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                numeroRomano = numeroRomano + "C";
            }
        }

        if (dezenas == 9) {
            numeroRomano = numeroRomano + "XC";
        } else if (dezenas >= 5) {
            numeroRomano = numeroRomano + "L";
            for (i = 6; i <= dezenas; i++) {
                numeroRomano = numeroRomano + "X";
            }
        } else if (dezenas == 4) {
            numeroRomano = numeroRomano + "XL";
        } else {
            for (i = 1; i <= dezenas; i++) {
                numeroRomano = numeroRomano + "X";
            }
        }

        if (unidades == 9) {
            numeroRomano = numeroRomano + "IX";
        } else if (unidades >= 5) {
            numeroRomano = numeroRomano + "V";
            for (i = 6; i <= unidades; i++) {
                numeroRomano = numeroRomano + "I";
            }
        } else if (unidades == 4) {
            numeroRomano = numeroRomano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                numeroRomano = numeroRomano + "I";
            }
        }
        return numeroRomano;
    }
}
