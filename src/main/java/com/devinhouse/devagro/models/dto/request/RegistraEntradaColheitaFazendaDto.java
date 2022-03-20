package com.devinhouse.devagro.models.dto.request;

import com.devinhouse.devagro.models.Fazenda;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistraEntradaColheitaFazendaDto {

    private Long id;
    private double estoque;
    @NotBlank(message = "Entrada de colheita não pode estar em branco!")
    private double entradaColheita;

    public Fazenda converterRegistraEntradaColheitaFazenda(){
        Fazenda fazenda = new Fazenda();

        fazenda.setId(this.getId());
        this.estoque = fazenda.getEstoque();
        return fazenda;

    }

    public double registraEntradaColheita(Fazenda fazendaEstoque){

        this.estoque = fazendaEstoque.getEstoque();
       return this.estoque += entradaColheita;

    }
}
