package learning_peru.ing_software.test.service.impl;

import learning_peru.ing_software.test.entity.User;
import learning_peru.ing_software.test.repositories.UserRepository;
import learning_peru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {

        String path="/home/lusho/Documents/Eduardo/5tociclo/SOFTWARE/proyecto_final/LearningPeruBD/src/main/java/learning_peru/ing_software/test/userFiles";
        user.setEnabled(true);
        User temp=userRepository.save(user);
        try {
            File file = new File(path +"/"+ temp.getId());
            file.mkdir();
            File file2 = new File(path +"/"+ temp.getId()+"/"+"materiales");
            File file3 = new File(path +"/"+ temp.getId()+"/"+"upgrade_files");
            file2.mkdir();
            file3.mkdir();
        }catch (Exception e){
            e.printStackTrace();
        }
        return temp;

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
            return new User();
        } else {
            return tmp;
        }
    }

    @Override
    public User findbyId(Long id) {
        Optional<User> user=userRepository.findById(id);
        return user.orElseGet(User::new);
    }
}
