package com.example.demo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class deserial extends JsonDeserializer<model> {

    @Override
    public model deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode root = p.getCodec().readTree(p);

        JsonNode userNode = root.get("user");

        model summary = new model();
        summary.setId(userNode.get("id").asLong());
        summary.setFirstName(userNode.get("name").get("first").asText());
        summary.setEmail(userNode.get("contact").get("email").asText());
        summary.setBillingCity(userNode.get("address").get("billing").get("city").asText());
        summary.setLanguage(userNode.get("preferences").get("language").asText());

        return summary;
    }
}