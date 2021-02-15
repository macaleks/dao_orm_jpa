package ru.otus.jdbcprj.dao;

import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Book;
import ru.otus.jdbcprj.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentRepositoryJpaImpl implements CommentRepositoryJpa {

    @PersistenceContext
    private final EntityManager em;

    public CommentRepositoryJpaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Comment> findByBookId(long id) {
        Book book = em.find(Book.class, id);
        return em.createQuery("select c from Comment c where c.book = :book")
                .setParameter("book", book)
                .getResultList();
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == 0L) {
            Book book = em.find(Book.class, comment.getBook().getId());
            comment.setBook(book);
            em.persist(comment);
            return comment;
        }
        return em.merge(comment);
    }
}
