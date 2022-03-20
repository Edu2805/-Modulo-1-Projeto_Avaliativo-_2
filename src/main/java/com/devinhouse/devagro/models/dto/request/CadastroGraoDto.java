package com.devinhouse.devagro.models.dto.request;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Grao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroGraoDto {

    @NotBlank(message = "Nome não pode estar em branco!")
    @Size(max = 60)
    private String nome;
    @NotNull(message = "Empresa não pode estar em branco!")
    private Empresa empresa;
    @NotNull(message = "Tempo médio de colheita não pode estar em branco!")
    private Long tempoMedioColheita;

    public Grao converter(){
        Grao grao = new Grao();
        grao.setNome(this.nome);
        grao.setEmpresa(this.empresa);
        grao.setTempoMedioColheita(this.tempoMedioColheita);
        return grao;
    }
}
