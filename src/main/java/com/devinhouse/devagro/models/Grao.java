package com.devinhouse.devagro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grao")
public class Grao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String nome;
    @Column(name = "tempo_medio_colheita", nullable = false)
    private Long tempoMedioColheita;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
