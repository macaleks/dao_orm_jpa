package ru.otus.jdbcprj.dao;

import ru.otus.jdbcprj.model.Comment;

import java.util.List;

public interface CommentRepositoryJpa {

    List<Comment> findByBookId(long id);

    Comment save(Comment comment);
}
