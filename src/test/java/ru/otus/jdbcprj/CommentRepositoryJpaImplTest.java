package ru.otus.jdbcprj;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.jdbcprj.dao.CommentRepositoryJpa;
import ru.otus.jdbcprj.dao.CommentRepositoryJpaImpl;
import ru.otus.jdbcprj.model.Book;
import ru.otus.jdbcprj.model.Comment;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(CommentRepositoryJpaImpl.class)
public class CommentRepositoryJpaImplTest {

    private static final int EXPECTED_NUMBER_OF_COMMENTS = 1;
    private static final long BOOK_ID = 2;
    private static final String COMMENT = "Nice to have";

    @Autowired
    CommentRepositoryJpa repo;

    @DisplayName("Find comments by book")
    @Test
    public void test_findComments() {
        List<Comment> comments = repo.findByBookId(BOOK_ID);
        assertEquals(EXPECTED_NUMBER_OF_COMMENTS, comments.size());
    }

    @DisplayName("Add a new comment for a book")
    @Test
    public void test_insert() {
        Book book = new Book();
        book.setId(BOOK_ID);
        Comment comment = new Comment(0L, book, COMMENT);
        Comment savedComment = repo.save(comment);

        assertThat(savedComment).isNotNull();
        assertThat(savedComment.getId()).isGreaterThan(0);
    }
}
