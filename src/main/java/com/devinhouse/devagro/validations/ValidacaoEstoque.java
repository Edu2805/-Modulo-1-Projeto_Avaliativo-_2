package com.devinhouse.devagro.validations;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidacaoEstoque {

    //Validação para não permitir estoque negativo
    public boolean validaEstoque(double estoque, double saida){

        if(saida > estoque){
            return true;
        }
        return false;
    }

    //Validação para evitar que o usuário digite um valor negativo
    public boolean validaEntrada(double entrada){

        if(entrada <= 0){
            return true;
        }
        return false;
    }

}
