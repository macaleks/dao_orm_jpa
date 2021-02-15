package ru.otus.jdbcprj.service;

import org.springframework.stereotype.Service;
import ru.otus.jdbcprj.dao.BookRepositoryJpa;
import ru.otus.jdbcprj.model.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepositoryJpa repo;

    public BookServiceImpl(BookRepositoryJpa bookDao) {
        this.repo = bookDao;
    }

    @Override
    public List<Book> getAll() {
        return repo.getAll();
    }

    @Transactional
    @Override
    public Book save(Book book) {
        return repo.save(book);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Transactional
    @Override
    public void updateNameById(long id, String name) {
        repo.updateNameById(id, name);
    }


}
