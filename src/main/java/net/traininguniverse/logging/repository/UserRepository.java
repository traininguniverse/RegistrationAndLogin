package net.traininguniverse.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.traininguniverse.logging.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
