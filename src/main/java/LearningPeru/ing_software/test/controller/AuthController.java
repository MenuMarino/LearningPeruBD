package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/Auth")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    User register(@RequestBody User user){

        User tmp = userService.findbyusername(user);
        if (tmp == null)
            return userService.save(user);
        else {
            //TODO: Retornar algo que diga que ya existe un usuario
            return null;
        }
    }

    /*
    @GetMapping(value = "/login")
    @ResponseBody
    User login(@RequestBody User user) {
        return userService.findbyCredentials(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    User FindAllByUsername(@RequestBody User user){
        return userService.findbyusername(user);
    }*/

    @GetMapping(value="/all")
    @ResponseBody
    List<User> getall(){
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value="/login")
    @ResponseBody
    User login(@RequestBody User user) {
        User temp= userService.findbyCredentials(user);
        if (temp!=null) {
            temp.setPassword(null);
            return temp;
        }else{
            return new User();
        }

    }

}
