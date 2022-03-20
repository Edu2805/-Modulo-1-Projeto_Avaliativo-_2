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

    @NotBlank(message = "Nome não pode estar em branco!")
    @Size(max = 60)
    private String nome;
    @NotBlank(message = "Sobrenome não pode estar em branco!")
    @Size(max = 60)
    private String sobrenome;
    @NotBlank(message = "Cpf não pode estar em branco!")
    @Size(max = 14)
    private String cpf;
    @NotBlank(message = "Endereço não pode estar em branco!")
    @Size(max = 100)
    private String endereco;
    @NotBlank(message = "Telefone não pode estar em branco!")
    @Size(max = 14)
    private String telefone;
    @NotNull(message = "Sexo não pode estar em branco!")
    private Sexo sexo;
    @NotNull(message = "Data de nascimento não pode estar em branco!")
    private LocalDate dataNascimento;
    @NotNull(message = "Data admissão não pode estar em branco!")
    private LocalDate dataAdmissao;
    @NotNull(message = "Empresa não pode estar em branco!")
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
