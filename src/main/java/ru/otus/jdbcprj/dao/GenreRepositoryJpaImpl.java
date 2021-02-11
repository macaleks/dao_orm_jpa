package ru.otus.jdbcprj.dao;

import org.springframework.stereotype.Repository;
import ru.otus.jdbcprj.model.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class GenreRepositoryJpaImpl implements GenreRepositoryJpa {

    @PersistenceContext
    private final EntityManager em;

    public GenreRepositoryJpaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }

    @Override
    public Genre getById(long id) {
        return em.find(Genre.class, id);
    }
}
