package ru.otus.jdbcprj.dao;

import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private final EntityManager em;


    public AuthorDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);
        List<Author> authors =  query.getResultList();
        authors.forEach(System.out::println);
        return authors;
    }

    @Override
    public Author getById(long id) {
        return em.find(Author.class, id);
    }
}
