package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {

    List<Grao> findGraosByEmpresa_Id(long id);
}
