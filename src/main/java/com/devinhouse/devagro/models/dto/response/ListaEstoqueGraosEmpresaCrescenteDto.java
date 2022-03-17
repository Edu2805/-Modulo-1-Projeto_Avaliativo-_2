package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Fazenda;
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

    private double estoque;
    private Grao grao;

}
