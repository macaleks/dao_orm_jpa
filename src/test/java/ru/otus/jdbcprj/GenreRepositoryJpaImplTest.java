package ru.otus.jdbcprj;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.jdbcprj.dao.GenreRepositoryJpa;
import ru.otus.jdbcprj.dao.GenreRepositoryJpaImpl;
import ru.otus.jdbcprj.model.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(GenreRepositoryJpaImpl.class)
public class GenreRepositoryJpaImplTest {

    private static final int EXPECTED_NUMBER_OF_GENRES = 9;
    private static final long GENRE_ID = 7;

    @Autowired
    GenreRepositoryJpa repo;

    @DisplayName("Should return 9 records")
    @Test
    public void test_getAll() {
        List<Genre> genre = repo.getAll();
        assertEquals(EXPECTED_NUMBER_OF_GENRES, genre.size());
    }

    @DisplayName("Find by id")
    @Test
    public void test_getById() {
        Genre genre = repo.getById(GENRE_ID);
        assertThat(genre).isNotNull();
        assertEquals(GENRE_ID, genre.getId());
    }
}
