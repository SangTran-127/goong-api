package org.sangtran.repository;

import org.sangtran.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

}
