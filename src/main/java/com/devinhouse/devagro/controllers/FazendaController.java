package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.dto.response.ListaEmpresasDto;
import com.devinhouse.devagro.models.dto.response.ListaFazendaEmpresaDto;
import com.devinhouse.devagro.models.dto.response.QuantidadeFazendasEmpresaDto;
import com.devinhouse.devagro.services.EmpresaService;
import com.devinhouse.devagro.services.FazendaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping(value = "/fazenda")
public class FazendaController {

    private FazendaService fazendaService;

    private ModelMapper modelMapper;

    public ListaFazendaEmpresaDto listaEmpresasConverter(Fazenda fazenda){
        return modelMapper.map(fazenda, ListaFazendaEmpresaDto.class);
    }

    @GetMapping(value = "/quantidadefazendas/{id}")
    public ResponseEntity<Fazenda> listaEmpresaId(@PathVariable Long id){
        Fazenda fazenda = fazendaService.findById(id);
        return ResponseEntity.ok().body(fazenda);
    }

    @GetMapping(value = "/listarfazendas/{id}")
    public ResponseEntity<List<ListaFazendaEmpresaDto>> listaFazendasEmpresa(@PathVariable Long id){
        return ResponseEntity.ok().body(fazendaService.findByIdAndEmpresaNome(id)
                .stream().map(this::listaEmpresasConverter)
                .collect(Collectors.toList()));
    }


    @PostMapping
    public ResponseEntity<Fazenda> insert(@RequestBody Fazenda fazenda){
        fazenda = fazendaService.add(fazenda);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(fazenda.getId()).toUri();

        return ResponseEntity.created(uri).body(fazenda);
    }
}
