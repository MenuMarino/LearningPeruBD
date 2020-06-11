package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/Auth")
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/all")
    List<User> find_all(){return userService.getAll();}

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
