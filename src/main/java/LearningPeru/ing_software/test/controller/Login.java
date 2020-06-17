package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.Type_of_user;
import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/login")
public class Login {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    User login(@RequestBody User user) {
        return userService.findbyCredentials(user);
    }
}
