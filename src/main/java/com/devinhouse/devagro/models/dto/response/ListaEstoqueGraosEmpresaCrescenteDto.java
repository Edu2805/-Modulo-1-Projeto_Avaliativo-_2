package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.models.dto.configuration.Serializador;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ListaEstoqueGraosEmpresaCrescenteDto {


    @JsonSerialize(using = Serializador.class)
    private Grao grao;
    private double estoque;

}
