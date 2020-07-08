package LearningPeru.ing_software.test.repositories;

import LearningPeru.ing_software.test.Entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword (String username, String password);



}
