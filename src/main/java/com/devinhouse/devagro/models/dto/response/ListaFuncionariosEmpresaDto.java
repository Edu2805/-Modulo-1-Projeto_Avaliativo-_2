package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.enumns.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListaFuncionariosEmpresaDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;
    private Empresa empresa;
}
