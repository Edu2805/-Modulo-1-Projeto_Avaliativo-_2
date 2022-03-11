package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.models.dto.response.ListaFuncionariosEmpresa;
import com.devinhouse.devagro.services.FuncionarioService;
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
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private ModelMapper modelMapper;

    public ListaFuncionariosEmpresa listaFuncionariosEmpresaDtoConverter(Funcionario funcionario) {
        return modelMapper.map(funcionario, ListaFuncionariosEmpresa.class);
    }

    @GetMapping(value = "/listarfuncionariosempresa/{id}")
    public ResponseEntity<List<ListaFuncionariosEmpresa>> listaGraosEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(funcionarioService.findFuncionarioByEmpresa_Id(id)
                .stream().map(this::listaFuncionariosEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/quantidadefuncionarios/{id}")
    public ResponseEntity<Integer> listaQuantidadeFuncionariosEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(funcionarioService.countFuncionarioByEmpresa_Id(id));
    }

    @PostMapping
    public ResponseEntity<Funcionario> insert(@RequestBody Funcionario funcionario){
        funcionario = funcionarioService.add(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(funcionario);
    }
}
