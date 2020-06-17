package LearningPeru.ing_software.test.service;

import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User create(User user);

    User findbyusername(User user);

    List<User> getAll();

    User findbyCredentials(User user);

}
