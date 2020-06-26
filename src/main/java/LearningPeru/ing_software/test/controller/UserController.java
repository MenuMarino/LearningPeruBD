package LearningPeru.ing_software.test.controller;
import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService UserService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    User update_user(@RequestBody User user){

        return UserService.save(user);
    }




}
