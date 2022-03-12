package com.devinhouse.devagro.models.dto.request;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Grao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroFazendaDto {

    @NotBlank
    @Size(max = 60)
    private String nome;
    @NotBlank
    @Size(max = 100)
    private String endereco;
    @NotBlank
    private Grao grao;
    @NotBlank
    private int estoque;
    @NotBlank
    private Empresa empresa;
    @NotNull
    private LocalDate ultimaColheita;

    public Fazenda converter(){
        Fazenda fazenda = new Fazenda();
        fazenda.setNome(this.nome);
        fazenda.setEndereco(this.endereco);
        fazenda.setGrao(this.grao);
        fazenda.setEstoque(this.estoque);
        fazenda.setEmpresa(this.empresa);
        fazenda.setUltimaColheita(this.ultimaColheita);
        return fazenda;
    }

}
