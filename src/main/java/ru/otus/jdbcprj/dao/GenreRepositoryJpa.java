package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Genre;

import java.util.List;

public interface GenreRepositoryJpa {

    List<Genre> getAll();

    Genre getById(long id);
}
