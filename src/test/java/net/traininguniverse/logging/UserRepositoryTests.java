package net.traininguniverse.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.traininguniverse.logging.domain.User;
import net.traininguniverse.logging.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("jan.brzechwa@gmail.com");
		user.setPassword("password");
		user.setFirstName("Jan");
		user.setLastName("Brzechwa");
		
		User savedUser = repo.save(user);//uzyskujemy id z DB
		User existUser = entityManager.find(User.class, savedUser.getId());//wyszukanie encji w DB
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	}
}
