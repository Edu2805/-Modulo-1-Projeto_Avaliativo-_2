package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findFazendasByEmpresa_Id(Long id);
    Integer countFazendaByEmpresa_Id(Long id);
    List<Fazenda> findFazendasByGrao_IdOrderByEstoque(Long id);
    List<Fazenda> findFazendasByEmpresa_IdOrderByEstoque(Long id);


    @Query(
            value = "SELECT F, F.grao.nome " +
                    "FROM Fazenda AS F " +
                    "INNER JOIN Grao AS G " +
                    "ON F.grao.nome = G.nome " +
                    "WHERE F.empresa.id = ?1 " +
                    "ORDER BY F.estoque ASC"
    )
    List<Fazenda> listaEstoqueGraosEmpresaAsc(Long id);

    //######## Tentar Alterar o DTO  de Fazenda para o método tradicional #########


    /*
    SELECT empresa.nome, grao.nome, fazenda.estoque
    FROM fazenda
    INNER JOIN empresa
    ON fazenda.empresa_id = empresa.id
    INNER JOIN grao
    ON fazenda.grao_id = grao.id
    WHERE empresa.id = 4
    ORDER BY fazenda.estoque
     */

    /*
    "SELECT F " +
                    "FROM Fazenda AS F " +
                    "INNER JOIN F.grao " +
                    "WHERE F.empresa.id = ?1 " +
                    "ORDER BY F.estoque ASC"
     */
}

