package com.carloseduardo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carloseduardo.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
