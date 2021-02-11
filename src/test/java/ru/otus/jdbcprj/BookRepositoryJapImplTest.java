package ru.otus.jdbcprj;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.jdbcprj.dao.BookRepositoryJpa;
import ru.otus.jdbcprj.dao.BookRepositoryJpaImpl;
import ru.otus.jdbcprj.model.Author;
import ru.otus.jdbcprj.model.Book;
import ru.otus.jdbcprj.model.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({BookRepositoryJpaImpl.class})
public class BookRepositoryJapImplTest {

    private static final int EXPECTED_NUMBER_OF_BOOKS = 3;
    private static final long GENRE_ID = 3L;
    private static final long AUTHOR_ID = 5L;
    private static final long BOOK_ID = 3L;
    private static final String BOOK_NAME = "New book";

    @Autowired
    BookRepositoryJpa bookRepo;

    @Autowired
    TestEntityManager em;

    @DisplayName("Should return 3 records")
    @Test
    public void test_getAll() {
        List<Book> books = bookRepo.getAll();
        assertEquals(EXPECTED_NUMBER_OF_BOOKS, books.size());
    }

    @DisplayName("Check that a new record saved")
    @Test
    public void test_insert() {
        Author author = new Author();
        author.setId(AUTHOR_ID);
        Genre genre = new Genre();
        genre.setId(GENRE_ID);
        val book = new Book(0L, "Book name", author, genre);
        bookRepo.save(book);
        assertThat(book.getId()).isGreaterThan(0);
    }

    @DisplayName("Update name by id")
    @Test
    public void test_update() {
        val book = em.find(Book.class, BOOK_ID);
        String oldName = book.getName();
        em.detach(book);

        bookRepo.updateNameById(BOOK_ID, BOOK_NAME);
        val updatedBook = em.find(Book.class, BOOK_ID);

        assertThat(updatedBook.getName()).isNotEqualTo(oldName).isEqualTo(BOOK_NAME);
    }

    @DisplayName("Delete by id")
    @Test
    public void test_delete() {
        val book = em.find(Book.class, BOOK_ID);
        assertThat(book).isNotNull();
        em.detach(book);

        bookRepo.deleteById(BOOK_ID);
        val deletedBook = em.find(Book.class, BOOK_ID);
        assertThat(deletedBook).isNull();
    }
}
