package ru.otus.jdbcprj.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcprj.dao.GenreDao;
import ru.otus.jdbcprj.model.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }


    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
