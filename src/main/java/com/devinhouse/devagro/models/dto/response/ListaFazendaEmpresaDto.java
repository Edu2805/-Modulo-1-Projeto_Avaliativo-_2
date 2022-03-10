package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListaFazendaEmpresaDto {

    private Long id;
    private String nome;
    private Empresa empresa;

}
