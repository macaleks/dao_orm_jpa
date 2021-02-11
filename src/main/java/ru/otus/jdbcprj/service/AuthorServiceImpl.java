package ru.otus.jdbcprj.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcprj.dao.AuthorRepositoryJpa;
import ru.otus.jdbcprj.model.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryJpa authorRepositoryJpa;

    public AuthorServiceImpl(AuthorRepositoryJpa authorRepositoryJpa) {
        this.authorRepositoryJpa = authorRepositoryJpa;
    }

    @Override
    public List<Author> getAll() {
        return authorRepositoryJpa.getAll();
    }
}
