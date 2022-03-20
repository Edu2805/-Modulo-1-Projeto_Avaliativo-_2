package com.devinhouse.devagro.repositories;

import com.devinhouse.devagro.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    //Método JPA para listar funcuinários de uma determinada empresa
    List<Funcionario> findFuncionarioByEmpresa_Id(Long id);

    //Método JPA para contar os funcionarios de uma empresa
    Integer countFuncionarioByEmpresa_Id(Long id);
}
