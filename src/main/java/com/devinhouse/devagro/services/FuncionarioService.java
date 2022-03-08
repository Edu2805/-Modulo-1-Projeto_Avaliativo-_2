package com.devinhouse.devagro.services;

import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.repositories.FazendaRepository;
import com.devinhouse.devagro.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.spel.spi.Function;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
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

    public void delete(Long id){
        funcionarioRepository.deleteById(id);
    }
}
