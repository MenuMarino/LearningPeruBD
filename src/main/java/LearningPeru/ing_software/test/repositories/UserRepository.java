package LearningPeru.ing_software.test.repositories;

import LearningPeru.ing_software.test.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword (String username, String password);

}
