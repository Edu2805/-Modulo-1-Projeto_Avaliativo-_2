package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.models.dto.response.ListaGraosEmpresaDto;
import com.devinhouse.devagro.services.GraoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/grao")
public class GraoController {

    private GraoService graoService;
    private ModelMapper modelMapper;

    public ListaGraosEmpresaDto listaGraosEmpresaDtoConverter(Grao grao) {
        return modelMapper.map(grao, ListaGraosEmpresaDto.class);
    }

    @GetMapping(value = "/listargraosempresa/{id}")
    public ResponseEntity<List<ListaGraosEmpresaDto>> listaGraosEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(graoService.findGraosByEmpresa_Id(id)
                .stream().map(this::listaGraosEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Grao> insert(@RequestBody Grao grao){
        grao = graoService.add(grao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(grao.getId()).toUri();

        return ResponseEntity.created(uri).body(grao);
    }
}
