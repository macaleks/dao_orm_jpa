package ru.otus.jdbcprj.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcprj.dao.AuthorDao;
import ru.otus.jdbcprj.model.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }
}
