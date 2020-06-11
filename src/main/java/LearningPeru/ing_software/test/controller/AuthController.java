package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/Auth")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    User register(@RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<User> FindAllByUsername(@RequestBody User user){
        return userService.getbyusername(user);
    }


}
