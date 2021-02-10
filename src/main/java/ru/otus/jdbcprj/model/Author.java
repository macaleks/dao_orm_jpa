package ru.otus.jdbcprj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false, unique = false)
    private String firstName;

    @Column(name = "second_name", nullable = false, unique = false)
    private String secondName;

    @Override
    public String toString() {
        return id + ", " + firstName + ", " + secondName;
    }
}
