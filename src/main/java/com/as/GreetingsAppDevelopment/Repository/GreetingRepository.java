package com.as.GreetingsAppDevelopment.Repository;

import com.as.GreetingsAppDevelopment.models.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greetings, Long> {
}
