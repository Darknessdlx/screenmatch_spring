package com.nexxxt.screenmatch_spring;

import com.nexxxt.screenmatch_spring.main.Main;
import com.nexxxt.screenmatch_spring.model.DatosEpisodio;
import com.nexxxt.screenmatch_spring.model.DatosSerie;
import com.nexxxt.screenmatch_spring.model.DatosTemporadas;
import com.nexxxt.screenmatch_spring.service.ConsumoAPI;
import com.nexxxt.screenmatch_spring.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Main principal = new Main();
        principal.muestraMenu();

    }
}
