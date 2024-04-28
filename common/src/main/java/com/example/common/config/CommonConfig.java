package com.example.common.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setVersion(1.0)
                .disableInnerClassSerialization()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .create();
    }
    
}
