package com.devinhouse.devagro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fazenda")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String nome;
    @Column(nullable = false, length = 100)
    private String endereco;
    @Column(nullable = false)
    private int estoque;
    @Column(name = "ultima_colheita", nullable = false)
    private LocalDate ultimaColheita;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "grao_id")
    private Grao grao;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
