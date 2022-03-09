package com.devinhouse.devagro.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaEmpresasDto {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;

}
