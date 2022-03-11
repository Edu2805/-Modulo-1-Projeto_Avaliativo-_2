package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Grao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListaEstoqueGraosEmpresaCrescenteDto {

    private Grao grao;
    private int estoque;
    private String nome;

}
