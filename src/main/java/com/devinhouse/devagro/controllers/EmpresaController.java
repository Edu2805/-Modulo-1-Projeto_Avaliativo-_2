package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.dto.response.ListaEmpresasDto;
import com.devinhouse.devagro.services.EmpresaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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
