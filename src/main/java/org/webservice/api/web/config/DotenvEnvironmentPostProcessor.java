package org.webservice.api.web.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class DotenvEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(
            ConfigurableEnvironment environment,
            SpringApplication application) {

        Dotenv dotenv = Dotenv.configure()
                //.directory(System.getProperty("user.dir"))
                .ignoreIfMissing()
                .load();

        Map<String, Object> env = dotenv.entries()
                .stream()
                .collect(java.util.stream.Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue()
                ));

        environment.getPropertySources()
                .addFirst(new MapPropertySource("dotenv", env));

        // DEBUG opcional
        //System.out.println(">>> dotenv DB_URL = " + env.get("DB_URL"));
        //System.out.println(">>> dotenv DB_USER = " + env.get("DB_USER"));
        //System.out.println(">>> dotenv DB_PASSWORD = " + env.get("DB_PASSWORD"));
        //System.out.println(">>> user.dir = " + System.getProperty("user.dir"));
    }
}
