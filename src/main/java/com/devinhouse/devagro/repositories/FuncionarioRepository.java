package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findFuncionarioByEmpresa_Id(Long id);
    Integer countFuncionarioByEmpresa_Id(Long id);
}
