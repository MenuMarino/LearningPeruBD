package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
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
        user.setPassword("jbellido");
        user.setName("Jesus");
        user.setLastname("Bellido");
        System.out.println(user.getUsername());
        userService.create(user);

        User user2=new User();
        user2.setUsername("yserrano");
        user2.setPassword("yserrano");
        user2.setName("Yamilet");
        user2.setLastname("Serrano");
        userService.create(user2);

        User user3=new User();
        user3.setUsername("josemaria");
        user3.setPassword("josemaria");
        user3.setName("jose");
        user3.setLastname("maria");
        userService.create(user3);

        User user4=new User();
        user4.setUsername("marialabandera");
        user4.setPassword("marialabandera");
        user4.setName("maria");
        user4.setLastname("La bandera");
        userService.create(user4);

        return userService.getAll();

    }
}
