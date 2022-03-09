package com.devinhouse.devagro.models.dto.response;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Fazenda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaFazendaEmpresaDto {

    private String nome;
    private List<Fazenda> fazendas;

}
