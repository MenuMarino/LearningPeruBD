package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.entity.Course;
import learning_peru.ing_software.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/courses")
public class CoursesController {
    @Autowired
    CourseService courseService;

    @GetMapping
    @ResponseBody
    public List<Course> getALL(){
        return courseService.getAll();
    }

    @GetMapping("/name")
    @ResponseBody
    public List<String> getCourses(){
        return courseService.getAllNames();
    }

    @PostMapping
    @ResponseBody
    public List<Course> initCourses(){
        String matematica = "Matematica";
        String quimica = "Quimica";
        String fisica = "Fisica";
        String lenguaje = "lenguaje";
        String biologia = "Biologia";

        //Grado 1
        Course curso1=new Course();
        curso1.setName(matematica);
        curso1.setGrade(1);
        curso1.setTheme("algebra_1");
        courseService.save(curso1);


        Course curso2=new Course();
        curso2.setName(fisica);
        curso2.setGrade(1);
        curso2.setTheme("MRU_1");
        courseService.save(curso2);
        Course curso3=new Course();
        curso3.setName(quimica);
        curso3.setGrade(1);
        curso3.setTheme("Atomos_1");
        courseService.save(curso3);
        Course curso4=new Course();
        curso4.setName(lenguaje);
        curso4.setGrade(1);
        curso4.setTheme("Sustantivos_1");
        courseService.save(curso4);
        Course curso5=new Course();
        curso5.setName(biologia);
        curso5.setGrade(1);
        curso5.setTheme("ADN_1");
        courseService.save(curso5);

        //Grado 2
        Course curso6=new Course();
        curso6.setName(matematica);
        curso6.setGrade(2);
        curso6.setTheme("algebra_2");
        courseService.save(curso6);
        Course curso7=new Course();
        curso7.setName(fisica);
        curso7.setGrade(2);
        curso7.setTheme("MRU_2");
        courseService.save(curso7);
        Course curso8=new Course();
        curso8.setName(quimica);
        curso8.setGrade(2);
        curso8.setTheme("Atomos_2");
        courseService.save(curso8);
        Course curso9=new Course();
        curso9.setName(lenguaje);
        curso9.setGrade(2);
        curso9.setTheme("Sustantivos_2");
        courseService.save(curso9);
        Course curso10=new Course();
        curso10.setName(biologia);
        curso10.setGrade(2);
        curso10.setTheme("ADN_2");
        courseService.save(curso10);

        //Grado 3
        Course curso11=new Course();
        curso11.setName(matematica);
        curso11.setGrade(3);
        curso11.setTheme("algebra_3");
        courseService.save(curso11);
        Course curso12=new Course();
        curso12.setName(fisica);
        curso12.setGrade(3);
        curso12.setTheme("MRU_3");
        courseService.save(curso12);
        Course curso13=new Course();
        curso13.setName(quimica);
        curso13.setGrade(3);
        curso13.setTheme("Atomos_3");
        courseService.save(curso13);
        Course curso14=new Course();
        curso14.setName(lenguaje);
        curso14.setGrade(3);
        curso14.setTheme("Sustantivos_3");
        courseService.save(curso14);
        Course curso15=new Course();
        curso15.setName(biologia);
        curso15.setGrade(3);
        curso15.setTheme("ADN_3");
        courseService.save(curso15);

        //Grado 4
        Course curso16=new Course();
        curso16.setName(matematica);
        curso16.setGrade(4);
        curso16.setTheme("algebra_4");
        courseService.save(curso16);
        Course curso17=new Course();
        curso17.setName(fisica);
        curso17.setGrade(4);
        curso17.setTheme("MRU_4");
        courseService.save(curso17);
        Course curso18=new Course();
        curso18.setName(quimica);
        curso18.setGrade(4);
        curso18.setTheme("Atomos_4");
        courseService.save(curso18);
        Course curso19=new Course();
        curso19.setName(lenguaje);
        curso19.setGrade(4);
        curso19.setTheme("Sustantivos_4");
        courseService.save(curso19);
        Course curso20=new Course();
        curso20.setName(biologia);
        curso20.setGrade(4);
        curso20.setTheme("ADN_4");
        courseService.save(curso20);

        //Grado 5
        Course curso21=new Course();
        curso21.setName(matematica);
        curso21.setGrade(5);
        curso21.setTheme("algebra_5");
        courseService.save(curso21);
        Course curso22=new Course();
        curso22.setName(fisica);
        curso22.setGrade(5);
        curso22.setTheme("MRU_5");
        courseService.save(curso22);
        Course curso23=new Course();
        curso23.setName(quimica);
        curso23.setGrade(5);
        curso23.setTheme("Atomos_5");
        courseService.save(curso23);
        Course curso24=new Course();
        curso24.setName(lenguaje);
        curso24.setGrade(5);
        curso24.setTheme("Sustantivos_5");
        courseService.save(curso24);
        Course curso25=new Course();
        curso25.setName(biologia);
        curso25.setGrade(5);
        curso25.setTheme("ADN_5");
        courseService.save(curso25);

        return courseService.getAll();
    }



    @GetMapping(value="/themes")
    @ResponseBody
    public List<String> themes(@RequestParam("name") String name, @RequestParam("grade") Integer grade){
        Course course = new Course();
        course.setGrade(grade);
        course.setName(name);
        return courseService.getAllThemes(course);
    }






}
