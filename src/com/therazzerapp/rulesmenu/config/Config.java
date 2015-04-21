package com.therazzerapp.rulesmenu.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 10:25 PM
 * Package: com.therazzerapp.rulesmenu.config
 * E-Mail: rezzer101@googlemail.com
 */

public class Config {
    public static void saveJsonFile(File file, JsonObject jsonObject) {
        try {
            try (JsonWriter jsonWriter = new JsonWriter(new FileWriter(file))) {
                jsonWriter.setIndent("    ");
                new Gson().toJson(jsonObject, jsonWriter);
                jsonWriter.flush();
            }
        } catch (IOException e) {
        }
    }

    public static JsonObject readJsonFile(File file) {
        try {
            JsonElement parse;
            try (JsonReader jsonReader = new JsonReader(new FileReader(file))) {
                parse = new JsonParser().parse(jsonReader);
            }
            if (parse == null || parse.isJsonNull()) {
                parse = new JsonObject();
            }
            return parse.getAsJsonObject();
        } catch (IOException ex) {
            return new JsonObject();
        }
    }

    public static void createConfig(File file){
        JsonObject root = new JsonObject();
        root.addProperty("maxRules",10);
        root.addProperty("cantBuild",false);
        root.addProperty("isFreezed",true);
        root.addProperty("chatSilent",false);
        root.addProperty("isMuted",false);
        root.addProperty("isSpectator",true);
        root.addProperty("kickOnDecline",true);
        root.addProperty("banOnDecline",false);
        root.addProperty("teleportToSpawnOnAccept",true);

        saveJsonFile(file,root);
    }
}
