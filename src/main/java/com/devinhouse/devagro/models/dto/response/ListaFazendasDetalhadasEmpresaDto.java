package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Fazenda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListaFazendasDetalhadasEmpresaDto {

    private Long id;
    private String nome;
    private LocalDate proximaColheita;

}
