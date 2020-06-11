package LearningPeru.ing_software.test.repositories;

import LearningPeru.ing_software.test.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    List<User> getByUsername(String username);

}
