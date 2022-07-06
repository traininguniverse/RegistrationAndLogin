package net.traininguniverse.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.traininguniverse.logging.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{

	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String username);

}
