package learning_peru.ing_software.test.controller;
import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.entity.User;
import learning_peru.ing_software.test.service.MaterialService;
import learning_peru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.cert.TrustAnchor;
import java.util.List;
import java.util.logging.LogManager;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MaterialService materialService;

    @PutMapping
    @ResponseBody
    public User updateUser(@RequestBody User user){
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

    @PostMapping(value = "/favourite/{userid}/{materialid}")
    @ResponseBody
    public User addToFavourite(@PathVariable("userid") Long userid, @PathVariable("materialid") Long materialid){

        User user = userService.findbyId(userid);
        List<Material> usersFavouriteMaterials = user.getFavouriteMaterials();
        Material material = materialService.findById(materialid);
        usersFavouriteMaterials.add(material);
        user.setFavouriteMaterials(usersFavouriteMaterials);
        return userService.save(user);

    }

    @DeleteMapping(value = "/favourite/{userid}/{materialid}")
    @ResponseBody
    public User deleteFromFavourite(@PathVariable("userid") Long userid, @PathVariable("materialid") Long materialid){

        User user = userService.findbyId(userid);
        List<Material> usersFavouriteMaterials = user.getFavouriteMaterials();
        int index=0;
        for (Material material:usersFavouriteMaterials){
            if (material.getId().equals(materialid)){
                usersFavouriteMaterials.remove(index);
                break;
            }else{
                index++;
            }
        }
        user.setFavouriteMaterials(usersFavouriteMaterials);
        return userService.save(user);


    }

    @GetMapping(value = "/mymaterials/{userId}")
    @ResponseBody
    public List<Material> getMyMaterials(@PathVariable("userId") Long userId){
        return userService.findbyId(userId).getMyMaterials();
    }



    @GetMapping(value = "/myfavmaterials/{userId}")
    @ResponseBody
    public List<Material> getMyFavouriteMaterials(@PathVariable("userId") Long userId){
        return userService.findbyId(userId).getFavouriteMaterials();
    }

    @GetMapping(value ="/myType")
    @ResponseBody
    public String getMyType(@RequestParam("userId")Long userId){
        return userService.findbyId(userId).getType().toString();
    }


    @GetMapping(value = "/isfavourite/{idU}/{idM}")
    @ResponseBody
    public Boolean isMyFavourite(@PathVariable("idU")Long idU, @PathVariable("idM")Long idM ){
        User usuario = userService.findbyId(idU);
        List<Material> favouriteMaterial = usuario.getFavouriteMaterials();
        for (Material material1:favouriteMaterial){
            if (material1.getId().equals(idM)){
                return true;
            }
        }
        return false;
    }
}
