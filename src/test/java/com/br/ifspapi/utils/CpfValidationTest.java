package com.br.ifspapi.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CpfValidationTest {

    @Test
    public void cpf_isValid(){
        String cpf = "095.100.779.33";

        String cpfSomenteDigitos = cpf.replaceAll("\\D", "");

        assertTrue(CpfValidationTest.isValid(cpfSomenteDigitos));
    }

    public static boolean isValid(String cpfSomenteDigitos){

        int[] PESO_CPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        if ((cpfSomenteDigitos == null) || (cpfSomenteDigitos.length() != 11) || cpfSomenteDigitos.equals("00000000000")
            || cpfSomenteDigitos.equals("11111111111") || cpfSomenteDigitos.equals("22222222222")
            || cpfSomenteDigitos.equals("33333333333") || cpfSomenteDigitos.equals("44444444444")
            || cpfSomenteDigitos.equals("55555555555") || cpfSomenteDigitos.equals("66666666666")
            || cpfSomenteDigitos.equals("77777777777") || cpfSomenteDigitos.equals("88888888888")
            || cpfSomenteDigitos.equals("99999999999")) {
        return false;
        }

        Integer digito1 = calcularDigito(cpfSomenteDigitos.substring(0, 9), PESO_CPF);
        Integer digito2 = calcularDigito(cpfSomenteDigitos.substring(0, 9) + digito1, PESO_CPF);

        return cpfSomenteDigitos.equals(cpfSomenteDigitos.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static int calcularDigito(String subs, int [] peso){
        int soma = 0;
        for (int indice = subs.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(subs.substring(indice, indice + 1));
            soma += digito * peso[peso.length - subs.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }


}
