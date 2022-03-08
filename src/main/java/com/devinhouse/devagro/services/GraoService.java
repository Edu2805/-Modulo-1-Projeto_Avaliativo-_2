package com.devinhouse.devagro.services;

import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.repositories.FuncionarioRepository;
import com.devinhouse.devagro.repositories.GraoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GraoService {

    private GraoRepository graoRepository;

    public List<Grao> findAll(){
        return graoRepository.findAll();
    }

    public Grao findById(Long id){
        return graoRepository.getById(id);
    }

    public Grao add(Grao grao){
        return graoRepository.save(grao);
    }

    public Grao update(Long id, Grao grao){
        Grao result = graoRepository.save(grao);
        return result;
    }

    public void delete(Long id){
        graoRepository.deleteById(id);
    }
}
