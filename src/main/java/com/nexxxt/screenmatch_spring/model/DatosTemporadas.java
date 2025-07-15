package com.nexxxt.screenmatch_spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Locale;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DatosTemporadas (
        @JsonAlias("Season")  Integer numero,
        @JsonAlias("Episodes") List<DatosEpisodio> episodios
) {
}
