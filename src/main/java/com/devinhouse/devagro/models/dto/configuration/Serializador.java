package com.devinhouse.devagro.models.dto.configuration;

import com.devinhouse.devagro.models.Grao;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class Serializador extends JsonSerializer <Grao>{
    @Override
    public void serialize(Grao grao, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        var nome = grao.getNome();
        jsonGenerator.writeString(nome.toString());

    }
}
