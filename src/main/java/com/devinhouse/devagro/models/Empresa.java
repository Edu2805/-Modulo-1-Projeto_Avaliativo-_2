package com.devinhouse.devagro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String nome;
    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;
    @Column(nullable = false, length = 100)
    private String endereco;

    @OneToMany(mappedBy = "empresa")
    private List<Fazenda> fazenda = new ArrayList<>();

    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionario = new ArrayList<>();

    @OneToMany(mappedBy = "empresa")
    private List<Grao> grao = new ArrayList<>();

}
