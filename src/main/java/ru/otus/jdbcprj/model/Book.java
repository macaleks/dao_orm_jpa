package ru.otus.jdbcprj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@NamedEntityGraph(name = "author-entity-graph", attributeNodes = {@NamedAttributeNode("author")})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_author")
    private Author author;

    @OneToOne(targetEntity = Genre.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genre")
    private Genre genre;

    @Override
    public String toString() {
        return id + ", " + name + ", {" + author + "}, {" + genre + "}";
    }
}
