package com.devinhouse.devagro.models;

import com.devinhouse.devagro.models.enumns.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String nome;
    @Column(nullable = false, length = 60)
    private String sobrenome;
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(nullable = false, length = 100)
    private String endereco;
    @Column(nullable = false, unique = true, length = 14)
    private String telefone;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //@JsonEnumDefaultValue - verificar
    private Sexo sexo;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
