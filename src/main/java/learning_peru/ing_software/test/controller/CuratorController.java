package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.entity.User;
import learning_peru.ing_software.test.service.MaterialService;
import learning_peru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/curator")
public class CuratorController {

    @Autowired
    UserService userService;

    @Autowired
    MaterialService materialService;

    @PostMapping("/accept/{iduser}/{idmaterial}")
    @ResponseBody
    public Boolean acceptMaterial(@PathVariable("iduser") Long iduser,@PathVariable("idmaterial") Long idmaterial){
        Material material= materialService.findById(idmaterial);
        User user = userService.findbyId(iduser);
        material.setStatus(2);
        material.setWhoApproved(user);
        materialService.save(material);
        return true;
    }

    @PostMapping("/negate/{iduser}/{idmaterial}")
    @ResponseBody
    public Boolean negateMaterial(@PathVariable("iduser") Long iduser,@PathVariable("idmaterial") Long idmaterial){
        Material material= materialService.findById(idmaterial);
        User user = userService.findbyId(iduser);
        material.setStatus(4);
        material.setWhoApproved(user);
        materialService.save(material);
        return true;
    }




}
