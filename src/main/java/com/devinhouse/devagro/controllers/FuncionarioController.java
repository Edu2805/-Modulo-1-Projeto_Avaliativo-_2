package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Funcionario;
import com.devinhouse.devagro.models.dto.request.CadastroFuncionarioDto;
import com.devinhouse.devagro.models.dto.response.ListaFuncionariosEmpresaDto;
import com.devinhouse.devagro.services.FuncionarioService;
import com.devinhouse.devagro.validations.ValidacaoCpf;
import com.devinhouse.devagro.validations.ValidacaoTelefone;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private ModelMapper modelMapper;

    //Aplicando os métodos do Model Mapper para conversão da entidade para DTO
    public ListaFuncionariosEmpresaDto listaFuncionariosEmpresaDtoConverter(Funcionario funcionario) {
        return modelMapper.map(funcionario, ListaFuncionariosEmpresaDto.class);
    }

    @GetMapping
    public ResponseEntity<List<ListaFuncionariosEmpresaDto>> listaFuncionarios() {
        return ResponseEntity.ok().body(funcionarioService.findAll()
                .stream().map(this::listaFuncionariosEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/listarfuncionariosempresa/{id}")
    public ResponseEntity<List<ListaFuncionariosEmpresaDto>> listaFuncionariosEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(funcionarioService.findFuncionarioByEmpresa_Id(id)
                .stream().map(this::listaFuncionariosEmpresaDtoConverter)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/quantidadefuncionarios/{id}")
    public ResponseEntity<Integer> listaQuantidadeFuncionariosEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok().body(funcionarioService.countFuncionarioByEmpresa_Id(id));
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody @Validated CadastroFuncionarioDto cadastroFuncionarioDto){

        var funcionario = new Funcionario();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(funcionario.getId()).toUri();

        //Verifica validação do telefone
        if(ValidacaoTelefone.validaTelefone(cadastroFuncionarioDto.getTelefone())) {
            if (ValidacaoCpf.formatoCpf(cadastroFuncionarioDto.converter().getCpf())) {

                //Verifica a validação do CPF
                String cpfVerificacao = ValidacaoCpf.trataCpf(cadastroFuncionarioDto.converter().getCpf());
                if (!ValidacaoCpf.isCPF(cpfVerificacao)) {

                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cpf inválido!");
                } else {
                    cpfVerificacao = ValidacaoCpf.imprimeCPF(cadastroFuncionarioDto.getCpf());
                    cadastroFuncionarioDto.setCpf(cpfVerificacao);
                    funcionarioService.add(cadastroFuncionarioDto.converter());

                    return ResponseEntity.created(uri).body(cadastroFuncionarioDto);
                }
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de telefone inválido, formato permitido: (XX) XXXXXXXXX!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de CPF inválido, formato permitido: XXX.XXX.XXX-XX!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id){
        Optional<Funcionario> funcionarioOptional = funcionarioService.findByIdDelete(id);
        if(!funcionarioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado!");
        }

        funcionarioService.delete(funcionarioOptional.get());
        return  ResponseEntity.ok().body("Funcionário excluído com sucesso!");
    }
}
