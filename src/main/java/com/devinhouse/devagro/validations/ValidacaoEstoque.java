package com.devinhouse.devagro.validations;

import com.devinhouse.devagro.models.Fazenda;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidacaoEstoque {

    public boolean validaEstoque(double estoque, double saida){

        if(saida > estoque){
            return true;
        }
        return false;
    }

    public boolean validaEntrada(double entrada){

        if(entrada <= 0){
            return true;
        }
        return false;
    }

}
