package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Book;

import java.util.List;

public interface BookRepositoryJpa {

    List<Book> getAll();

    Book save(Book book);

    void deleteById(long id);

    void updateNameById(long id, String name);
}
