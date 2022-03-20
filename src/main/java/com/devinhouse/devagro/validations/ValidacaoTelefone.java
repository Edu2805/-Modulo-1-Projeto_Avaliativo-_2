package com.devinhouse.devagro.validations;

public class ValidacaoTelefone {

    //Regex para validação de número de telefone
    public static boolean validaTelefone(String telefone){

        return telefone.matches("([(][0-9]{2}[)] [0-9]{9})");
    }
}
