package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> getAll();

    Author getById(long id);
}
