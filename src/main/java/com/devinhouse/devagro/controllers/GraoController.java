package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.services.FuncionarioService;
import com.devinhouse.devagro.services.GraoService;
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
@RequestMapping(value = "/grao")
public class GraoController {

    private GraoService graoService;

    @PostMapping
    public ResponseEntity<Grao> insert(@RequestBody Grao grao){
        grao = graoService.add(grao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(grao.getId()).toUri();

        return ResponseEntity.created(uri).body(grao);
    }
}
