package com.aavash.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class ConfigurationService {
    private final File SETTING_FILE = new File("setting.json");
    private Gson gson = new GsonBuilder().create();

    public ConfigModel getConfiguration() throws IOException{
        if(!SETTING_FILE.exists()){
            createSettingsFile();
        }
        return getConfigurationFromFile();
    }
    private ConfigModel getConfigurationFromFile() throws IOException {
        ConfigModel configModel = new ConfigModel();
        try(Reader reader = new FileReader(SETTING_FILE)){
            return gson.fromJson(reader,ConfigModel.class);
        }
    }

    private void createSettingsFile() throws IOException {
        ConfigModel configModel = new ConfigModel();
        try(Writer writer = new FileWriter(SETTING_FILE,false)){
            gson.toJson(configModel,writer);
        }
    }

}
