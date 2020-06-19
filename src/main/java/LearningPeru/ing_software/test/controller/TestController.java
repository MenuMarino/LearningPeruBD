package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.Type_of_user;
import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    List<User> tester(){
        User user= new User();
        user.setUsername("jbellido");
        user.setPassword(DigestUtils.sha256Hex("jbellido"));
        user.setName("Jesus");
        user.setLastname("Bellido");
        //user.setType("STUDENT");
        user.setType(Type_of_user.ADMIN);
        System.out.println(user.getUsername());
        userService.create(user);

        User user2=new User();
        user2.setUsername("yserrano");
        user2.setPassword(DigestUtils.sha256Hex("yserrano"));
        user2.setName("Yamilet");
        user2.setLastname("Serrano");
        user2.setType(Type_of_user.CURATOR);
        userService.create(user2);

        User user3=new User();
        user3.setUsername("josemaria");
        user3.setPassword(DigestUtils.sha256Hex("josemaria"));
        user3.setName("Jose");
        user3.setLastname("Maria");
        user3.setType(Type_of_user.TEACHER);
        userService.create(user3);

        User user4=new User();
        user4.setUsername("silvialabandera");
        user4.setPassword(DigestUtils.sha256Hex("silvialabandera"));
        user4.setName("Silvia");
        user4.setLastname("La bandera");
        user4.setType(Type_of_user.STUDENT);
        userService.create(user4);

        User user5=new User();
        user5.setUsername("enrique");
        user5.setPassword(DigestUtils.sha256Hex("enrique"));
        user5.setName("Enrique");
        user5.setLastname("Sobrados");
        user5.setType(Type_of_user.TWAITING);
        userService.create(user5);



        return userService.getAll();

    }
}
