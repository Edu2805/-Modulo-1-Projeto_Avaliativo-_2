package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.models.dto.request.CadastroGraoDto;
import com.devinhouse.devagro.models.dto.response.ListaEstoqueGraosEmpresaCrescenteDto;
import com.devinhouse.devagro.models.dto.response.ListaGraosDto;
import com.devinhouse.devagro.models.dto.response.ListaGraosEmpresaDto;
import com.devinhouse.devagro.services.GraoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/grao")
public class GraoController {

    private GraoService graoService;
    private ModelMapper modelMapper;

    public ListaGraosDto listaGraosEmpresaDtoConverter(Grao grao) {
        return modelMapper.map(grao, ListaGraosDto.class);
    }

    public ListaGraosEmpresaDto listaGraosEmpresaDto(Grao grao) {
        return modelMapper.map(grao, ListaGraosEmpresaDto.class);
    }

//    public ListaEstoqueGraosEmpresaCrescenteDto listaEstoqueGraosEmpresaCrescenteDto(Grao grao) {
//        return modelMapper.map(grao, ListaEstoqueGraosEmpresaCrescenteDto.class);
//    }

//    @GetMapping(value = "/estoquegraoscrescente/{id}")
//    public ResponseEntity<List<ListaEstoqueGraosEmpresaCrescenteDto>> listaGraosEmpresaEstoqueAsc(@PathVariable Long id) {
//
//
//        return ResponseEntity.ok().body(graoService.listaEstoqueGraosEmpresaAsc(id)
//                .stream().map(this::listaEstoqueGraosEmpresaCrescenteDto)
//                .collect(Collectors.toList()));
//    }

    @GetMapping(value = "/listargraosempresa/{id}")
    public ResponseEntity<List<ListaGraosEmpresaDto>> listaGraosEmpresa(@PathVariable Long id) {

        return ResponseEntity.ok().body(graoService.findGraosByEmpresa_Id(id)
                .stream().map(this::listaGraosEmpresaDto)
                .collect(Collectors.toList()));
    }


    @GetMapping
    public ResponseEntity<List<ListaGraosDto>> listaGraos() {
        return ResponseEntity.ok().body(graoService.findAll()
                .stream().map(this::listaGraosEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CadastroGraoDto> insert(@RequestBody @Valid CadastroGraoDto cadastroGraoDto){
        var grao = new Grao();
        grao = graoService.add(cadastroGraoDto.converter());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(grao.getId()).toUri();

        return ResponseEntity.created(uri).body(cadastroGraoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id){
        Optional<Grao> graoOptional = graoService.findByIdDelete(id);
        if(!graoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grão não encontrado!");
        }

        graoService.delete(graoOptional.get());
        return  ResponseEntity.ok().body("Grão excluído com sucesso!");
    }
}
