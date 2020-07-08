package learning_peru.ing_software.test.repositories;

import learning_peru.ing_software.test.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword (String username, String password);



}
