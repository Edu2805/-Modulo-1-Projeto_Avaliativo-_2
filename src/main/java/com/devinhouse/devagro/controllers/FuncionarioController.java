package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.services.FazendaService;
import com.devinhouse.devagro.services.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> insert(@RequestBody Funcionario funcionario){
        funcionario = funcionarioService.add(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(funcionario);
    }
}
