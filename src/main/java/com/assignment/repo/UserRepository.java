package com.assignment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByCommentTo(String commentTo);
}
