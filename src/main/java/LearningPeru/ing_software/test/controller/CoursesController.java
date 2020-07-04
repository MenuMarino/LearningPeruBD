package LearningPeru.ing_software.test.controller;


import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.Entity.Material;
import LearningPeru.ing_software.test.repositories.CourseRepository;
import LearningPeru.ing_software.test.repositories.MaterialRepository;
import LearningPeru.ing_software.test.service.CourseService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/courses")
public class CoursesController {
    @Autowired
    CourseService courseService;

    @GetMapping
    @ResponseBody
    List<Course> getALL(){
        return courseService.getAll();
    }

    @GetMapping("/name")
    @ResponseBody
    List<String> GetCourses(){
        return courseService.getAllNames();
    }

    @PostMapping
    @ResponseBody
    List<Course> initCourses(){
        //TODO iniciar
        //Grado 1
        Course curso1=new Course();
        curso1.setName("Matematica");
        curso1.setGrade(1);
        curso1.setTheme("algebra 1");
        Material material1= new Material();
        material1.setLearning_Points(420);
        material1.setRatingPeople(69);
        material1.setCourse(curso1);
        Material material2= new Material();
        material2.setLearning_Points(500);
        material2.setRatingPeople(10);
        material2.setCourse(curso1);
        List<Material> temp= new ArrayList<>();
        temp.add(material1);
        temp.add(material2);
        curso1.setMateriales(temp);

        courseService.save(curso1);


        Course curso2=new Course();
        curso2.setName("Fisica");
        curso2.setGrade(1);
        curso2.setTheme("MRU 1");
        courseService.save(curso2);
        Course curso3=new Course();
        curso3.setName("Quimica");
        curso3.setGrade(1);
        curso3.setTheme("Atomos 1");
        courseService.save(curso3);
        Course curso4=new Course();
        curso4.setName("Lenguaje");
        curso4.setGrade(1);
        curso4.setTheme("Sustantivos 1");
        courseService.save(curso4);
        Course curso5=new Course();
        curso5.setName("Biologia");
        curso5.setGrade(1);
        curso5.setTheme("ADN 1");
        courseService.save(curso5);

        //Grado 2
        Course curso6=new Course();
        curso6.setName("Matematica");
        curso6.setGrade(2);
        curso6.setTheme("algebra 2");
        courseService.save(curso6);
        Course curso7=new Course();
        curso7.setName("Fisica");
        curso7.setGrade(2);
        curso7.setTheme("MRU 2");
        courseService.save(curso7);
        Course curso8=new Course();
        curso8.setName("Quimica");
        curso8.setGrade(2);
        curso8.setTheme("Atomos 2");
        courseService.save(curso8);
        Course curso9=new Course();
        curso9.setName("Lenguaje");
        curso9.setGrade(2);
        curso9.setTheme("Sustantivos 2");
        courseService.save(curso9);
        Course curso10=new Course();
        curso10.setName("Biologia");
        curso10.setGrade(2);
        curso10.setTheme("ADN 2");
        courseService.save(curso10);

        //Grado 3
        Course curso11=new Course();
        curso11.setName("Matematica");
        curso11.setGrade(3);
        curso11.setTheme("algebra 3");
        courseService.save(curso11);
        Course curso12=new Course();
        curso12.setName("Fisica");
        curso12.setGrade(3);
        curso12.setTheme("MRU 3");
        courseService.save(curso12);
        Course curso13=new Course();
        curso13.setName("Quimica");
        curso13.setGrade(3);
        curso13.setTheme("Atomos 3");
        courseService.save(curso13);
        Course curso14=new Course();
        curso14.setName("Lenguaje");
        curso14.setGrade(3);
        curso14.setTheme("Sustantivos 3");
        courseService.save(curso14);
        Course curso15=new Course();
        curso15.setName("Biologia");
        curso15.setGrade(3);
        curso15.setTheme("ADN 3");
        courseService.save(curso15);

        //Grado 4
        Course curso16=new Course();
        curso16.setName("Matematica");
        curso16.setGrade(4);
        curso16.setTheme("algebra 4");
        courseService.save(curso16);
        Course curso17=new Course();
        curso17.setName("Fisica");
        curso17.setGrade(4);
        curso17.setTheme("MRU 4");
        courseService.save(curso17);
        Course curso18=new Course();
        curso18.setName("Quimica");
        curso18.setGrade(4);
        curso18.setTheme("Atomos 4");
        courseService.save(curso18);
        Course curso19=new Course();
        curso19.setName("Lenguaje");
        curso19.setGrade(4);
        curso19.setTheme("Sustantivos 4");
        courseService.save(curso19);
        Course curso20=new Course();
        curso20.setName("Biologia");
        curso20.setGrade(4);
        curso20.setTheme("ADN 4");
        courseService.save(curso20);

        //Grado 5
        Course curso21=new Course();
        curso21.setName("Matematica");
        curso21.setGrade(5);
        curso21.setTheme("algebra 5");
        courseService.save(curso21);
        Course curso22=new Course();
        curso22.setName("Fisica");
        curso22.setGrade(5);
        curso22.setTheme("MRU 5");
        courseService.save(curso22);
        Course curso23=new Course();
        curso23.setName("Quimica");
        curso23.setGrade(5);
        curso23.setTheme("Atomos 5");
        courseService.save(curso23);
        Course curso24=new Course();
        curso24.setName("Lenguaje");
        curso24.setGrade(5);
        curso24.setTheme("Sustantivos 5");
        courseService.save(curso24);
        Course curso25=new Course();
        curso25.setName("Biologia");
        curso25.setGrade(5);
        curso25.setTheme("ADN 5");
        courseService.save(curso25);

        return courseService.getAll();

    }

    @GetMapping(value = "/search")
    @ResponseBody
    List<Course> Search(@RequestBody Course course){
        return courseService.SpecificSearch(course);
    }

    @GetMapping(value="/themes")
    @ResponseBody
    List<String> Themes(@RequestBody Course course){
        return courseService.getAllThemes(course);
    }




}
