package LearningPeru.ing_software.test.controller;


import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.service.CourseService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/courses")
public class CoursesController {
    @Autowired
    CourseService courseService;

    @GetMapping
    @ResponseBody
    List<Course> GetCourses(){
        return courseService.getAll();
    }

    @PostMapping
    @ResponseBody
    String initCourses(){

        //TODO iniciar
        Course curso1=new Course();
        curso1.setName("Matematica");
        curso1.setGrade(2);
        curso1.setTheme("algebra");
        courseService.save(curso1);
        return "DONE";

    }

    @GetMapping(value = "/search")
    @ResponseBody
    List<Course> Search(@RequestBody Course course){
        return courseService.SpecificSearch(course);
    }



}
