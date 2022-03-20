package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    // Método JPA para buscar as fazendas de uma empresa
    List<Fazenda> findFazendasByEmpresa_Id(Long id);

    // Método JPA para contar quantas fazendas uma determinada empresa possui
    Integer countFazendaByEmpresa_Id(Long id);

    /*
    Query personalizada para listar o estoque de graos de uma empresa de forma ascendente
    Neste método foram feitos joins entre as entidades Fazenda e Grao
     */
    @Query(
            value = "SELECT F " +
                    "FROM Fazenda AS F " +
                    "INNER JOIN Grao AS G " +
                    "ON F.grao.id = G.id " +
                    "WHERE F.empresa.id = ?1 " +
                    "ORDER BY F.estoque ASC"
    )
    List<Fazenda> listaEstoqueGraosEmpresaAsc(Long id);

}

