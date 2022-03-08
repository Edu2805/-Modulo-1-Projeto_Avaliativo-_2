package com.devinhouse.devagro.models.dto;

import com.devinhouse.devagro.models.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;

}
