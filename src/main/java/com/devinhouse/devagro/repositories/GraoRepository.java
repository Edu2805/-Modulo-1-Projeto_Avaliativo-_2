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

}
