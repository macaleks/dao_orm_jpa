package ru.otus.jdbcprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.jdbcprj.dao.CommentRepositoryJpa;
import ru.otus.jdbcprj.model.Comment;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepositoryJpa repo;

    public CommentServiceImpl(CommentRepositoryJpa repo) {
        this.repo = repo;
    }

    @Override
    public List<Comment> findByBookId(long id) {
        return repo.findByBookId(id);
    }

    @Transactional
    @Override
    public Comment save(Comment comment) {
        return repo.save(comment);
    }
}
