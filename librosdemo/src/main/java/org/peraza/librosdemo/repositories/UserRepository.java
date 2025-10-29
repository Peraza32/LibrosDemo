package org.peraza.librosdemo.repositories;

import org.peraza.librosdemo.models.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    User save(User user);
}
