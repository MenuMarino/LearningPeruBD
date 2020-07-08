package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Auth")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<User> register(@RequestBody User user){

        User tmp = userService.findbyusername(user);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        headers.add("Access-Control-Allow-Headers", "X-Requested-With, X-Auth-Token");
        headers.add("Access-Control-Allow-Credentials", "true");
        if (tmp == null) {
            return new ResponseEntity<>(userService.save(user),headers,HttpStatus.OK);
        }else {

            return new ResponseEntity<User>(new User(),HttpStatus.BAD_REQUEST);
        }
    }




    @GetMapping(value="/all")
    @ResponseBody
    public List<User> getall(){
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value="/login")
    @ResponseBody
    public User login(@RequestBody User user) {
        User temp= userService.findbyCredentials(user);
        if (temp!=null) {
            temp.setPassword(null);
            return temp;
        }else{
            return new User();
        }

    }

}
