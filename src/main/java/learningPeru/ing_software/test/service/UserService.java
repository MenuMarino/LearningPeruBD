package learningPeru.ing_software.test.service;

import learningPeru.ing_software.test.Entity.User;


import java.util.List;

public interface UserService {

    User save(User user);

    User findbyusername(User user);

    List<User> getAll();

    User findbyCredentials(User user);

    User findbyId(Long id);
}
