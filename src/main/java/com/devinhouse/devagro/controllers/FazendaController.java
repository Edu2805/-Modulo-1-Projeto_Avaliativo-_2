package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.dto.response.ListaFazendaEmpresaDto;
import com.devinhouse.devagro.models.dto.response.ListaFazendasDto;
import com.devinhouse.devagro.services.FazendaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/fazenda")
public class FazendaController {

    private FazendaService fazendaService;
    private ModelMapper modelMapper;

    //Convert DTOs
    public ListaFazendasDto listaFazendasDtoConverter(Fazenda fazenda) {
        return modelMapper.map(fazenda, ListaFazendasDto.class);
    }

    public ListaFazendaEmpresaDto listaFazendasEmpresaDtoConverter(Fazenda fazenda) {
        return modelMapper.map(fazenda, ListaFazendaEmpresaDto.class);
    }

    @GetMapping
    public ResponseEntity<List<ListaFazendasDto>> listaFazendas() {

        return ResponseEntity.ok().body(fazendaService.findAll()
                .stream()
                .map(this::listaFazendasDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/quantidadefazendas/{id}")
    public ResponseEntity<Fazenda> listaEmpresaId(@PathVariable Long id) {
        Fazenda fazenda = fazendaService.findById(id);
        return ResponseEntity.ok().body(fazenda);
    }

    @GetMapping(value = "/listarfazendas/{id}")
    public ResponseEntity<List<ListaFazendaEmpresaDto>> listaFazendasEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(fazendaService.findFazendasByEmpresa(id)
                .stream().map(this::listaFazendasEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }
}
