package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.dto.response.ListaEmpresasDto;
import com.devinhouse.devagro.models.dto.response.ListaFazendaEmpresaDto;
import com.devinhouse.devagro.models.dto.response.QuantidadeFazendasEmpresaDto;
import com.devinhouse.devagro.services.EmpresaService;
import com.devinhouse.devagro.services.FazendaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

    private EmpresaService empresaService;
    private ModelMapper modelMapper;

    public ListaEmpresasDto listaEmpresasConverter(Empresa empresa){
        return modelMapper.map(empresa, ListaEmpresasDto.class);
    }

    @GetMapping
    public ResponseEntity<List<ListaEmpresasDto>> listaEmpresas(){

        return ResponseEntity.ok().body(empresaService.findAll()
                .stream()
                .map(this::listaEmpresasConverter)
                .collect(Collectors.toList()));
    }

}
