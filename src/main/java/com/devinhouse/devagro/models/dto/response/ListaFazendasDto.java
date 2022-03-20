package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Grao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListaFazendasDto {

    private Long id;
    private String nome;
    private String endereco;
    private int estoque;
    private LocalDate ultimaColheita;
    private Grao grao;

}
