package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.repositories.UserRepository;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findbyusername(User user) {
        return userRepository.findByUsername(user.getUsername());
    }

    @Override
    public List<User> getAll() {
        List<User> temp=new ArrayList<>();
        userRepository.findAll().forEach(temp::add);
        return temp;
    }

    @Override
    public User findbyCredentials(User user) {
        User tmp = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (tmp == null){
            User vacio = new User();
            return vacio;
        } else {
            return tmp;
        }
    }
}
