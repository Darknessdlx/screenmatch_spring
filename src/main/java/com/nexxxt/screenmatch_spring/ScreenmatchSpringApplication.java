package com.nexxxt.screenmatch_spring;

import com.nexxxt.screenmatch_spring.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoAPI();
        var json = consumoApi.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=d4d0bf92");

        System.out.println(json);
    }
}
