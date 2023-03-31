package org.sangtran.repository;

import org.sangtran.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface LogRepository extends JpaRepository<Log, Integer> {

    @Query("from Log where customerId = ?1")
    Optional<Log> findByUserId(Integer customerId);
}
