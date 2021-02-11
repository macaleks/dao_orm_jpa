package ru.otus.jdbcprj.dao;

import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Author;
import ru.otus.jdbcprj.model.Book;
import ru.otus.jdbcprj.model.Genre;

import javax.persistence.*;
import java.util.List;

@Repository
public class BookRepositoryJpaImpl implements BookRepositoryJpa {

    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpaImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<Book> getAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("author-entity-graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b left join fetch b.genre",
                Book.class);
        query.setHint("javax.persistance.fetchgraph", entityGraph);
        return query.getResultList();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0L) {
            Author author = em.find(Author.class, book.getAuthor().getId());
            Genre genre = em.find(Genre.class, book.getGenre().getId());
            book.setAuthor(author);
            book.setGenre(genre);
            em.persist(book);
            return book;
        }
        return em.merge(book);
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete from Book b where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update Book b " +
                "set b.name = :name " +
                "where b.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }


}
