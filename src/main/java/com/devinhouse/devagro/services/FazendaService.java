package com.devinhouse.devagro.services;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.repositories.EmpresaRepository;
import com.devinhouse.devagro.repositories.FazendaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor
@Service
public class FazendaService {

    private FazendaRepository fazendaRepository;

    public List<Fazenda> findAll(){
        return fazendaRepository.findAll();
    }

    public Fazenda findById(Long id){
        return fazendaRepository.getById(id);
    }

    public Fazenda add(Fazenda fazenda){
        return fazendaRepository.save(fazenda);
    }

    public Fazenda update(Long id, Fazenda fazenda){
        Fazenda result = fazendaRepository.save(fazenda);
        return result;
    }

    public void delete(Long id){
        fazendaRepository.deleteById(id);
    }

    public List<Fazenda> findFazendasByEmpresa(Long id){
        return fazendaRepository.findFazendasByEmpresa_Id(id);
    }
}
