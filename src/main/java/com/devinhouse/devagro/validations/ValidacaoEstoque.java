package com.devinhouse.devagro.validations;

import com.devinhouse.devagro.models.Fazenda;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidacaoEstoque {

    public boolean validaEstoque(int estoque, int saida){

        if(saida > estoque){
            return true;
        }
        return false;
    }

}
