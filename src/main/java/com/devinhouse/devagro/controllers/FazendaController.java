package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.Fazenda;
import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.models.Grao;
import com.devinhouse.devagro.models.dto.request.CadastroFazendaDto;
import com.devinhouse.devagro.models.dto.request.CadastroGraoDto;
import com.devinhouse.devagro.models.dto.request.RegistraEntradaColheitaFazendaDto;
import com.devinhouse.devagro.models.dto.request.RegistraSaidaColheitaFazendaDto;
import com.devinhouse.devagro.models.dto.response.*;
import com.devinhouse.devagro.services.FazendaService;
import com.devinhouse.devagro.validations.ValidacaoEstoque;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/fazenda")
public class FazendaController {

    private FazendaService fazendaService;
    private ModelMapper modelMapper;
    private ValidacaoEstoque validacaoEstoque;

    //Convert DTOs
    public ListaFazendasDto listaFazendasDtoConverter(Fazenda fazenda) {
        return modelMapper.map(fazenda, ListaFazendasDto.class);
    }

    public ListaFazendaEmpresaDto listaFazendasEmpresaDtoConverter(Fazenda fazenda) {
        return modelMapper.map(fazenda, ListaFazendaEmpresaDto.class);
    }

    public ListaFazendasDetalhadasEmpresaDto listaFazendasEmpresaDetalhadaDtoConverter(Fazenda fazenda) {
        return modelMapper.map(fazenda, ListaFazendasDetalhadasEmpresaDto.class);
    }

    public ListaEstoqueGraosEmpresaCrescenteDto listaEstoqueGraosEmpresaCrescenteDto(Fazenda fazenda) {
        return modelMapper.map(fazenda, ListaEstoqueGraosEmpresaCrescenteDto.class);
    }

    @GetMapping
    public ResponseEntity<List<ListaFazendasDto>> listaFazendas() {

        return ResponseEntity.ok().body(fazendaService.findAll()
                .stream()
                .map(this::listaFazendasDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/listarfazendasempresa/{id}")
    public ResponseEntity<List<ListaFazendaEmpresaDto>> listaFazendasEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(fazendaService.findFazendasByEmpresa(id)
                .stream().map(this::listaFazendasEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/quantidadefazendas/{id}")
    public ResponseEntity<Integer> listaQuantidadeFazendasEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(fazendaService.countFazendasByEmpresa_Id(id));
    }

    @GetMapping(value = "/listafazendasdetalhadas/{id}")
    public ResponseEntity<List<ListaFazendasDetalhadasEmpresaDto>> listaFazendasDetalhadasEmpresa(@PathVariable Long id) {


        //Usar o ResultSet...
        return ResponseEntity.ok().body(fazendaService.findFazendasByEmpresa(id)
                .stream().map(this::listaFazendasEmpresaDetalhadaDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/estoquegraoscrescente/{id}")
    public ResponseEntity<List<ListaEstoqueGraosEmpresaCrescenteDto>> listaGraosEmpresaEstoqueAsc(@PathVariable Long id) {

        return ResponseEntity.ok().body(fazendaService.findFazendaByGrao_IdAndEstoqueOrderByEmpresaEstoqueAsc(id)
                .stream().map(this::listaEstoqueGraosEmpresaCrescenteDto)
                .collect(Collectors.toList()));
    }

    @PutMapping(value = "/registraentradacolheita/{id}")
    public ResponseEntity<Fazenda> registraEntradaColheita(@PathVariable Long id, @RequestBody RegistraEntradaColheitaFazendaDto registraColheitaFazendaDto){

        Optional<Fazenda> optionalFazenda = fazendaService.findByIdUpDate(id);
        Fazenda fazenda = optionalFazenda.get();

        //Verificação para valor não ser negativo
        fazenda.setEstoque(registraColheitaFazendaDto.registraEntradaColheita(fazenda));
        fazenda.setUltimaColheita(LocalDate.now());

        return  ResponseEntity.ok().body(fazendaService.update(fazendaService.update(fazenda)));
    }

    @PutMapping(value = "/registrasaidacolheita/{id}")
    public ResponseEntity<Object> registraSaidaColheita(@PathVariable Long id, @RequestBody RegistraSaidaColheitaFazendaDto registraSaidaColheitaFazendaDto){

        Optional<Fazenda> optionalFazenda = fazendaService.findByIdUpDate(id);
        Fazenda fazenda = optionalFazenda.get();

        if(validacaoEstoque.validaEstoque(optionalFazenda.get().getEstoque(), registraSaidaColheitaFazendaDto.getSaidaColheita())){
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                    .buildAndExpand(fazenda.getId()).toUri();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Estoque insuficiente!");
        }

        fazenda.setEstoque(registraSaidaColheitaFazendaDto.registraSaidaColheita(fazendaService.update(fazenda)));
        return  ResponseEntity.ok().body(fazendaService.update(fazendaService.update(fazenda)));
    }

    @PostMapping
    public ResponseEntity<CadastroFazendaDto> insert(@RequestBody @Valid CadastroFazendaDto cadastroFazendaDto){
        var fazenda = new Fazenda();
        fazenda = fazendaService.add(cadastroFazendaDto.converter());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(fazenda.getId()).toUri();

        return ResponseEntity.created(uri).body(cadastroFazendaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id){
        Optional<Fazenda> fazendaOptional = fazendaService.findByIdDelete(id);
        if(!fazendaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
        }

        fazendaService.delete(fazendaOptional.get());
        return  ResponseEntity.ok().body("Fazenda excluída com sucesso!");
    }
}
