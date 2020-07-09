package learning_peru.ing_software.test.controller;


import learning_peru.ing_software.test.beans.NewMaterialBean;
import learning_peru.ing_software.test.entity.Course;
import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.entity.User;
import learning_peru.ing_software.test.service.CourseService;
import learning_peru.ing_software.test.service.MaterialService;
import learning_peru.ing_software.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    MaterialService materialService;


    @PostMapping(value="/create")
    @ResponseBody
    public User save(@RequestBody NewMaterialBean materialBean){
        User whoPosted =userService.findbyId(materialBean.getId());
        List<Material> userMaterialList=whoPosted.getMyMaterials();
        Course course= new Course();
        course.setGrade(materialBean.getGrade());
        course.setName(materialBean.getCourse());
        course.setTheme(materialBean.getTheme());
        course =courseService.specificSearch(course);
        List<Material> materialList= course.getMateriales();

        Material material= new Material();
        material.setStatus(0);
        material.setRatingPeople(0);
        material.setLearningPoints(0);
        material.setDownloads(0);
        material.setVisits(0);
        material.setDate(new Date());
        material.setDescription(materialBean.getDescription());
        material.setName(materialBean.getName());
        material=materialService.save(material);

        materialList.add(material);
        userMaterialList.add(material);

        //añade el curso a la lista de materiales
        course.setMateriales(materialList);

        //añade el curso a la lista de materiales del profe
        whoPosted.setMyMaterials(userMaterialList);

        //añade el user y el curso al material
        material.setWhoPosted(whoPosted);
        material.setCourse(course);

        courseService.save(course);
        return userService.save(whoPosted);


    }

    @GetMapping(value = "/search")
    @ResponseBody
    public List<Material> search(@RequestParam("name") String name, @RequestParam("grade") Integer grade, @RequestParam("theme") String theme, @RequestParam("page") Integer page) {
        Course course = new Course();
        course.setGrade(grade);
        course.setTheme(theme);
        course.setName(name);
        course = courseService.specificSearch(course);

        return materialService.getAllByCourse(course,page);
    }


    @PostMapping("/status/{id}/{status}")
    @ResponseBody
    public User changeStatus(@PathVariable("id") Long id, @PathVariable("status") Integer status){
        Material material=materialService.findById(id);
        material.setStatus(status);
        materialService.save(material);
        return material.getWhoPosted();
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public Material GetById(@PathVariable("id") Long id){
        return materialService.findById(id);
    }

    @GetMapping("/needcurate/{page}")
    @ResponseBody
    public List<Material> getNotCuratedMaterials(@PathVariable("page") Integer page){
        return materialService.getNotCuratedMaterials(page);
    }


}
