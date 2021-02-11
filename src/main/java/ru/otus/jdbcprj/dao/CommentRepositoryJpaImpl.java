package ru.otus.jdbcprj.dao;

import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Book;
import ru.otus.jdbcprj.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        TypedQuery<Comment> query = em.createQuery("select c from Comment c join fetch c.book " +
                "where c.book.id = :id", Comment.class);
        query.setParameter("id", id);
        return query.getResultList();
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
