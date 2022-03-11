package com.devinhouse.devagro.models.dto.request;

import com.devinhouse.devagro.models.Fazenda;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistraEntradaColheitaFazendaDto {

    private Long id;
    private int estoque;
    private int entradaColheita;

    public Fazenda converterRegistraEntradaColheitaFazenda(){
        Fazenda fazenda = new Fazenda();

        fazenda.setId(this.getId());
        this.estoque = fazenda.getEstoque();
        return fazenda;

    }

    public int registraEntradaColheita(Fazenda fazendaEstoque){

        this.estoque = fazendaEstoque.getEstoque();
       return this.estoque += entradaColheita;

    }
}
