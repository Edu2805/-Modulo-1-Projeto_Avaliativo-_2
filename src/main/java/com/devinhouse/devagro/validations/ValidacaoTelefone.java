package com.devinhouse.devagro.validations;

public class ValidacaoTelefone {

    public static boolean validaTelefone(String telefone){

        return telefone.matches("([(][0-9]{2}[)] [0-9]{9})");
    }
}
