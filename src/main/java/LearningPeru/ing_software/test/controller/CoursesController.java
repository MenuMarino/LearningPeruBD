package LearningPeru.ing_software.test.controller;


import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.service.CourseService;
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

    @PostMapping
    @ResponseBody
    List<Course> GetCourses(){
        return courseService.getAll();
    }

    @GetMapping
    void initCourses(){

        //TODO iniciar
        Course curso1=new Course();
        curso1.setName("Matematica");
        curso1.setGrade(2);
        curso1.setTheme("");


    }


}
