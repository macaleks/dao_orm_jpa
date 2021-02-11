package ru.otus.jdbcprj.service;

import ru.otus.jdbcprj.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findByBookId(long id);

    Comment save(Comment comment);
}
