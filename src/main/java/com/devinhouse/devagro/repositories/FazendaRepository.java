package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findFazendasByEmpresa_Id(Long id);
    Integer countFazendaByEmpresa_Id(Long id);

    @Query(
            value = "SELECT F " +
                    "FROM Fazenda AS F " +
                    "INNER JOIN Grao AS G " +
                    "ON F.grao.nome = G.nome " +
                    "INNER JOIN Empresa AS E " +
                    "ON F.empresa.nome = E.nome " +
                    "WHERE F.empresa.id = ?1 " +
                    "ORDER BY F.estoque ASC"
    )
    List<Fazenda> listaEstoqueGraosEmpresaAsc(Long id);

}

