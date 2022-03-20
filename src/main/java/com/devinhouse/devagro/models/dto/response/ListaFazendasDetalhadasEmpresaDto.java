package com.devinhouse.devagro.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListaFazendasDetalhadasEmpresaDto {

    private Long id;
    private String nome;
    private String proximaColheita;

}
