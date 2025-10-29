package org.peraza.librosdemo.repositories;

import org.peraza.librosdemo.models.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findbyUsernameAndPassword(String username, String password);
    void createUser(User user);
}
