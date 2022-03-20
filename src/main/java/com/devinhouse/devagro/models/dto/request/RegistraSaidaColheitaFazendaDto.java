package com.devinhouse.devagro.models.dto.request;

import com.devinhouse.devagro.models.Fazenda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistraSaidaColheitaFazendaDto {

    private Long id;
    private double estoque;
    @NotBlank
    private double saidaColheita;


    public Fazenda converterRegistraEntradaColheitaFazenda(){
        Fazenda fazenda = new Fazenda();

        fazenda.setId(this.getId());
        this.estoque = fazenda.getEstoque();
        return fazenda;

    }

    public double registraSaidaColheita(Fazenda fazendaEstoque){

        this.estoque = fazendaEstoque.getEstoque();
        return this.estoque -= saidaColheita;

    }
}
