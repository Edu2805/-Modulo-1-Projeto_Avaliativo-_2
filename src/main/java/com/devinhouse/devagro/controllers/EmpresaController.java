package com.devinhouse.devagro.controllers;

import com.devinhouse.devagro.models.Empresa;
import com.devinhouse.devagro.models.dto.request.CadastroEmpresaDto;
import com.devinhouse.devagro.models.dto.response.ListaEmpresasDto;
import com.devinhouse.devagro.services.EmpresaService;
import com.devinhouse.devagro.validations.ValidacaoCnpj;
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
@RequestMapping(value = "/empresa")
public class EmpresaController {

    private EmpresaService empresaService;
    private ModelMapper modelMapper;

    //Aplicando os métodos do Model Mapper para conversão da entidade para DTO
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

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody @Validated CadastroEmpresaDto cadastroEmpresaDto){
        var empresa = new Empresa();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
                .buildAndExpand(empresa.getId()).toUri();

            //Validação do CNPJ
            if (ValidacaoCnpj.formatoCnpj(cadastroEmpresaDto.converter().getCnpj())) {

                String cnpjVerificacao = ValidacaoCnpj.trataCnpj(cadastroEmpresaDto.converter().getCnpj());
                if (!ValidacaoCnpj.isCNPJ(cnpjVerificacao)) {

                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ inválido!");
                } else {
                    cnpjVerificacao = ValidacaoCnpj.imprimeCNPJ(cadastroEmpresaDto.getCnpj());
                    cadastroEmpresaDto.setCnpj(cnpjVerificacao);
                    empresaService.add(cadastroEmpresaDto.converter());

                    return ResponseEntity.created(uri).body(cadastroEmpresaDto);
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de CNPJ inválido, formato permitido: XX.XXX.XXX/XXXX-XX!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id){
        Optional<Empresa> empresaOptional = empresaService.findByIdDelete(id);

        //Verifica se a empresa existe ou não antes de excluir
        if(!empresaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada!");
        }
        empresaService.delete(empresaOptional.get());
        return  ResponseEntity.ok().body("Empresa excluída com sucesso!");
    }

}
