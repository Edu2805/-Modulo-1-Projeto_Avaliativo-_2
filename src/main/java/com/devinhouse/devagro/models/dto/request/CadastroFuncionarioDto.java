package com.devinhouse.devagro.models.dto.request;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.models.enumns.Sexo;
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
public class CadastroFuncionarioDto {

    @NotBlank
    @Size(max = 60)
    private String nome;
    @NotBlank
    @Size(max = 60)
    private String sobrenome;
    @NotBlank
    @Size(max = 14)
    private String cpf; //validar cpf com regex
    @NotBlank
    @Size(max = 100)
    private String endereco;
    @NotBlank
    @Size(max = 14)
    private String telefone; //validar telefone com regex
    @NotNull
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private LocalDate dataAdmissao;
    @NotNull
    private Empresa empresa;

    public Funcionario converter(){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(this.nome);
        funcionario.setSobrenome(this.sobrenome);
        funcionario.setCpf(this.cpf);
        funcionario.setEndereco(this.endereco);
        funcionario.setTelefone(this.telefone);
        funcionario.setSexo(this.sexo);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setDataAdmissao(this.dataAdmissao);
        funcionario.setEmpresa(this.empresa);
        return funcionario;
    }

}
