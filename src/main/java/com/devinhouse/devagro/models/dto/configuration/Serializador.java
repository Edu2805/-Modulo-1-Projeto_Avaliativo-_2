package com.devinhouse.devagro.models.dto.configuration;

import com.devinhouse.devagro.models.Grao;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class Serializador extends JsonSerializer <Grao>{

    /*
    A criação de um serializer foi necessária para que a classe Grão chamada como um atributo dentro da classe
    ListaEstoqueGraoEmpresaCrescenteDto não exibisse todo o conteúdo presente em Grão.
    Nesye caso, foi usado no end-pont lista gãos associados a uma empresa onde será necessário mostrar
    somente o nome do grão e a quantidade em estoque por ordem ascendente.
    Com o serializer, foi possível buscar somente o atributo "nome" dentro da classe grão para ser incorporada ao JSON.
     */
    @Override
    public void serialize(Grao grao, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        var nome = grao.getNome();
        jsonGenerator.writeString(nome.toString());

    }
}
