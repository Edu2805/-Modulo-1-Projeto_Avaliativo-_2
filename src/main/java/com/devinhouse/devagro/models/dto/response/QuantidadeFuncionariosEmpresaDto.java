package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeFuncionariosEmpresaDto {

    private String nome;
    private Empresa empresa;
}
