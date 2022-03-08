package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.dto.EmpresaDto;
import com.devinhouse.devagro.services.EmpresaService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> listaEmpresas(){

        List<Empresa> list = empresaService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> listaEmpresaId(@PathVariable Long id){
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(empresa);
    }

    @PostMapping
    public  ResponseEntity<Empresa> insert(@RequestBody Empresa empresa){
        empresa = empresaService.add(empresa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(empresa.getId()).toUri();

        return ResponseEntity.created(uri).body(empresa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@RequestBody @Validated Empresa empresa, UriComponentsBuilder uriBuilder){

        return  ResponseEntity.ok().body(empresaService.update(empresa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
