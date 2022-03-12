package com.devinhouse.devagro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @Min(value = 0L, message = "Estoque insuficiente")
    private int estoque;
    @Column(name = "ultima_colheita")
    private LocalDate ultimaColheita;

    @ManyToOne
    @JoinColumn(name = "grao_id")
    private Grao grao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
