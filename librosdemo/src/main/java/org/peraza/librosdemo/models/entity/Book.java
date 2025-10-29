package org.peraza.librosdemo.models.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private UUID id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "summary")
    private String summary;

    @Column(name = "price")
    private Float price;

    @Column(name = "book_state")
    private String state;

    @Column(name = "image")
    private String img;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gen_id")
    private Genre genre;
}
