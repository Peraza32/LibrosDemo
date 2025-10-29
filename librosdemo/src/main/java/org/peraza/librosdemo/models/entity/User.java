package org.peraza.librosdemo.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "passwd", nullable = false)
    private String password;

    @Column(name = "user_state", nullable = false)
    private String state;

    @OneToMany(mappedBy = "user")
    private List<Book> books;
}
