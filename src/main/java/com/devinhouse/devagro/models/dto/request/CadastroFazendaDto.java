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

    @NotBlank(message = "Nome não pode estar em branco!")
    @Size(max = 60)
    private String nome;
    @NotBlank(message = "Endereço não pode estar em branco!")
    @Size(max = 100)
    private String endereco;
    @NotNull(message = "Grão não pode estar em branco!")
    private Grao grao;
    @NotNull(message = "Estoque não pode estar em branco!")
    private double estoque;
    @NotNull(message = "Empresa não pode estar em branco!")
    private Empresa empresa;
    private LocalDate ultimaColheita;

    public Fazenda converter(){
        Fazenda fazenda = new Fazenda();
        fazenda.setNome(this.nome);
        fazenda.setEndereco(this.endereco);
        fazenda.setGrao(this.grao);
        fazenda.setEstoque(this.estoque);
        fazenda.setEmpresa(this.empresa);
        fazenda.setUltimaColheita(LocalDate.now());
        return fazenda;
    }

}
