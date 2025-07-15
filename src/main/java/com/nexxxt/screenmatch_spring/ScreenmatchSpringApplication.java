package com.nexxxt.screenmatch_spring;

import com.nexxxt.screenmatch_spring.model.DatosEpisodio;
import com.nexxxt.screenmatch_spring.model.DatosSerie;
import com.nexxxt.screenmatch_spring.model.DatosTemporadas;
import com.nexxxt.screenmatch_spring.service.ConsumoAPI;
import com.nexxxt.screenmatch_spring.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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

        ConvierteDatos conversor = new ConvierteDatos();
        var datos = conversor.obtenerDatos(json, DatosSerie.class);

        System.out.println(datos);

        json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&Episode=1&apikey=d4d0bf92");
        DatosEpisodio episodio = conversor.obtenerDatos(json, DatosEpisodio.class);

        System.out.println(episodio);

        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++){
            json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=" + i + "&apikey=d4d0bf92");
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        temporadas.forEach(System.out::println);
    }
}
