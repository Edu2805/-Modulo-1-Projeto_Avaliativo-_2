package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {

    @Query(value = "SELECT DISTINCT G " +
            "FROM Grao AS G " +
            "INNER JOIN Fazenda AS F " +
            "ON F.grao.id = G.id " +
            "INNER JOIN Empresa AS E " +
            "ON F.empresa.id = E.id " +
            "WHERE F.empresa.id = ?1")
    List<Grao> listaGraosPorEmpresa(Long id);


//    @Query(
//            value = "SELECT DISTINCT G, F " +
//                    "FROM Fazenda AS F " +
//                    "INNER JOIN Empresa AS E " +
//                    "ON F.empresa.id = E.id " +
//                    "INNER JOIN Grao AS G " +
//                    "ON F.grao.id = G.id " +
//                    "WHERE F.empresa.id = ?1 " +
//                    "ORDER BY F.estoque ASC"
//    )
//    List<Grao> listaEstoqueGraosEmpresaAsc(Long id);

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
}
