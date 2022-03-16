package com.devinhouse.devagro.services;

import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.repositories.GraoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Grao add(Grao grao){
        return graoRepository.save(grao);
    }

    public Grao update(Long id, Grao grao){
        Grao result = graoRepository.save(grao);
        return result;
    }

    @Transactional
    public void delete(Grao grao){
        graoRepository.delete(grao);
    }


    public Optional<Grao> findByIdDelete(Long id) {
        return graoRepository.findById(id);
    }

    public List<Grao> findGraosByEmpresa_Id(long id){
        return graoRepository.listaGraosPorEmpresa(id);
    }
}
