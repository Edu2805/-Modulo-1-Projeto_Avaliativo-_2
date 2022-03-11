package com.devinhouse.devagro.validations;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class ValidacaoEstoque {

    private double estoque;
    private double valorEstoque;

    public boolean validaEstoque(double estoque){

        if(estoque < 0.0){

            return false;
        }

        return true;
    }

}
