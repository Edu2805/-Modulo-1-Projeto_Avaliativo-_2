package com.devinhouse.devagro.services;

import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id){
        return funcionarioRepository.getById(id);
    }


    public Funcionario add(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario){
        Funcionario result = funcionarioRepository.save(funcionario);
        return result;
    }


    public void delete(Funcionario funcionario){
        funcionarioRepository.delete(funcionario);
    }

    public List<Funcionario> findFuncionarioByEmpresa_Id(Long id){
        return funcionarioRepository.findFuncionarioByEmpresa_Id(id);
    }

    public Integer countFuncionarioByEmpresa_Id(Long id){
        return funcionarioRepository.countFuncionarioByEmpresa_Id(id);
    }

    public Optional<Funcionario> findByIdDelete(Long id) {
        return funcionarioRepository.findById(id);
    }

}
