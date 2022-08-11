package com.thekim12.main.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>  {
	User findByUsername(String username);
}
