package LearningPeru.ing_software.test.controller;
import LearningPeru.ing_software.test.Entity.Material;
import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.MaterialService;
import LearningPeru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MaterialService materialService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    User update_user(@RequestBody User user){
        User temp = userService.findbyId(user.getId());
        if( user.getUsername()!=null ){
            temp.setUsername(user.getUsername());
        }
        if (user.getEmail()!=null ){
            temp.setEmail(user.getEmail());
        }
        if (user.getPassword()!= null){
            user.setEmail(user.getPassword());
        }
        return userService.save(temp);
    }

    @PostMapping(value = "favourite/{userid}/{materialid}")
    @ResponseBody
    Boolean addToFavourite(@PathVariable("userid") Long userid, @PathVariable("materialid") Long materialid){
        try {
            User user = userService.findbyId(userid);
            List<Material> usersFavouriteMaterials = user.getFavouriteMaterials();
            Material material = materialService.find_by_id(materialid);
            usersFavouriteMaterials.add(material);
            user.setFavouriteMaterials(usersFavouriteMaterials);
            userService.save(user);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }




}
