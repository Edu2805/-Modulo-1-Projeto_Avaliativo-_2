package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {


//    SELECT fazenda.nome, fazenda.empresa_id
//    FROM fazenda
//    INNER JOIN empresa
//    ON fazenda.empresa_id = empresa.id
//    WHERE fazenda.empresa_id=1
    
    List<Fazenda> findByIdAndEmpresaNome(Long id);

}

