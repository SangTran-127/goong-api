package org.sangtran.repository;

import org.sangtran.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}