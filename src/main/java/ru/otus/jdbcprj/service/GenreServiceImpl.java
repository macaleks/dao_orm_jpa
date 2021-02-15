package ru.otus.jdbcprj.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcprj.dao.GenreRepositoryJpa;
import ru.otus.jdbcprj.model.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepositoryJpa genreRepositoryJpa;

    public GenreServiceImpl(GenreRepositoryJpa genreRepositoryJpa) {
        this.genreRepositoryJpa = genreRepositoryJpa;
    }


    @Override
    public List<Genre> getAll() {
        return genreRepositoryJpa.getAll();
    }
}
