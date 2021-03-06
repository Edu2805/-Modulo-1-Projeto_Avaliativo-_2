package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Fazenda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeFazendasEmpresaDto {

    private String nome;
    private List<Fazenda> fazendas;

}
