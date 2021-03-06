package com.devinhouse.devagro.models.dto.request;

import com.devinhouse.devagro.models.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroEmpresaDto {

    @NotBlank(message = "Nome não pode estar em branco!")
    @Size(max = 60)
    private String nome;
    @NotBlank(message = "CNPJ não pode estar em branco!")
    @Size(max = 18)
    private String cnpj;
    @NotBlank(message = "Endereço não pode estar em branco!")
    @Size(max = 100)
    private String endereco;

    public Empresa converter(){
        Empresa empresa = new Empresa();
        empresa.setNome(this.nome);
        empresa.setCnpj(this.cnpj);
        empresa.setEndereco(this.endereco);
        return empresa;
    }
}
