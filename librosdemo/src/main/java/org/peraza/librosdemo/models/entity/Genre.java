package org.peraza.librosdemo.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;

    @Column(name = "genre_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Book> book;
}
