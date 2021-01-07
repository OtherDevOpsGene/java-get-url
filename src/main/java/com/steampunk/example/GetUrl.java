package com.steampunk.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GetUrl {

    private String readStringFromURL(final String requestURL) throws IOException {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
                StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    private String formatJson(final String json) {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final JsonElement je = JsonParser.parseString(json);
        return gson.toJson(je);
    }

    public static void main(String[] args) throws IOException {
        final GetUrl getUrl = new GetUrl();
        final String json = getUrl.readStringFromURL("https://sonarqube.dhsice.name/api/ce/task?id=AXaRL8n0yC3iCptSZTOc");
        System.out.println(getUrl.formatJson(json));
    }
}
