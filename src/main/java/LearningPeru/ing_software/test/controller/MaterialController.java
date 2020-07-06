package LearningPeru.ing_software.test.controller;


import LearningPeru.ing_software.test.Beans.NewMaterialBean;
import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.Entity.Material;
import LearningPeru.ing_software.test.Entity.User;
import LearningPeru.ing_software.test.service.CourseService;
import LearningPeru.ing_software.test.service.MaterialService;
import LearningPeru.ing_software.test.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/material")
public class MaterialController {

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;


    @PostMapping(value="/create")
    @ResponseBody
    User save(@RequestBody NewMaterialBean materialBean){
        User who_posted =userService.findbyId(materialBean.getId());
        List<Material> user_material_list=who_posted.getMyMaterials();
        Course course= new Course();
        course.setGrade(materialBean.getGrade());
        course.setName(materialBean.getCourse());
        course.setTheme(materialBean.getTheme());
        course =courseService.SpecificSearch(course);
        List<Material> materialList= course.getMateriales();

        Material material= new Material();
        material.setRatingPeople(0);
        material.setLearning_Points(0);
        material.setDownloads(0);
        material.setVisits(0);
        material.setDate(new Date());
        material.setDescription(materialBean.getDescription());
        material.setName(materialBean.getName());
        materialList.add(material);
        user_material_list.add(material);

        //añade el curso a la lista de materiales
        course.setMateriales(materialList);

        //añade el curso a la lista de materiales del profe
        who_posted.setMyMaterials(user_material_list);

        //añade el user y el curso al material
        material.setWho_posted(who_posted);
        material.setCourse(course);

        courseService.save(course);
        return userService.save(who_posted);


    }

    @GetMapping(value = "/search")
    @ResponseBody
    List<Material> Search(@RequestParam("name") String name,@RequestParam("grade") Integer grade,@RequestParam("theme") String theme) {
        Course course = new Course();
        course.setGrade(grade);
        course.setTheme(theme);
        course.setName(name);
        course = courseService.SpecificSearch(course);
        List<Material> retorno = new ArrayList<>();
        for (Material material : course.getMateriales()) {
            if (material.getEstado() == 2) {
                retorno.add(material);
            }
        }
        return retorno;
    }
}
