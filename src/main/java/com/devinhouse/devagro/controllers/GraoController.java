package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.models.dto.request.CadastroGraoDto;
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

    public ListaGraosEmpresaDto listaGraosEmpresaDtoConverter(Grao grao) {
        return modelMapper.map(grao, ListaGraosEmpresaDto.class);
    }

    @GetMapping
    public ResponseEntity<List<ListaGraosEmpresaDto>> listaGraos() {
        return ResponseEntity.ok().body(graoService.findAll()
                .stream().map(this::listaGraosEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/listargraosempresa/{id}")
    public ResponseEntity<List<ListaGraosEmpresaDto>> listaGraosEmpresa(@PathVariable Long id) {

        /*
        SELECT DISTINCT empresa.nome, grao.nome
        FROM fazenda
        INNER JOIN empresa
        ON fazenda.empresa_id = empresa.id
        INNER JOIN grao
        ON fazenda.grao_id = grao.id
        WHERE empresa.id = 2
         */



        return ResponseEntity.ok().body(graoService.findGraosByEmpresa_Id(id)
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
