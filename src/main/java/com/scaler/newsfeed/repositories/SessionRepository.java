package com.scaler.newsfeed.repositories;

import com.scaler.newsfeed.models.Session;
import com.scaler.newsfeed.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
    Optional<Session> findByUser(User user);
}
