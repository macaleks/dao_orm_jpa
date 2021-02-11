package ru.otus.jdbcprj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    @Column(name = "comment")
    private String comment;

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", book=" + book + ", comment='" + comment + '}';
    }
}
