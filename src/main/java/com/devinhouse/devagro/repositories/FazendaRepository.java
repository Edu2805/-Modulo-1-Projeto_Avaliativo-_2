package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findFazendasByEmpresa_Id(Long id);
    Integer countFazendaByEmpresa_Id(Long id);
    List<Fazenda> findFazendasByGrao_IdOrderByEstoque(Long id);
}

