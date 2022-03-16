package com.devinhouse.devagro.services;

import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.models.dto.response.ListaFazendasDetalhadasEmpresaDto;
import com.devinhouse.devagro.repositories.FazendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Fazenda add(Fazenda fazenda){
        return fazendaRepository.save(fazenda);
    }

    public Fazenda update(Fazenda fazenda){


        Fazenda result = fazendaRepository.save(fazenda);
        return result;
    }

    public Optional<Fazenda> findByIdUpDate(Long id){
        return fazendaRepository.findById(id);
    }

    @Transactional
    public void delete(Fazenda fazenda){
        fazendaRepository.delete(fazenda);
    }

    public List<Fazenda> findFazendasByEmpresa(Long id){
        return fazendaRepository.findFazendasByEmpresa_Id(id);
    }

    public Integer countFazendasByEmpresa_Id(Long id){
        return fazendaRepository.countFazendaByEmpresa_Id(id);
    }

    public List<Fazenda> findFazendaByGrao_IdAndEstoqueOrderByEmpresaEstoqueAsc(Long id){
        return fazendaRepository.findFazendasByGrao_IdOrderByEstoque(id);
    }

    public Optional<Fazenda> findByIdDelete(Long id) {
        return fazendaRepository.findById(id);
    }

}
