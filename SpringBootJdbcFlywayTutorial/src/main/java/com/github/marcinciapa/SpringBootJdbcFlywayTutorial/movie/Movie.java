package com.github.marcinciapa.SpringBootJdbcFlywayTutorial.movie;

import com.github.marcinciapa.SpringBootJdbcFlywayTutorial.actor.Actor;

import java.time.LocalDate;
import java.util.List;

public record Movie(Integer id,
                    String name,
                    List<Actor> actors,
                    LocalDate releaseDate) {
}