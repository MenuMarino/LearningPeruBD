package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.*;
import LearningPeru.ing_software.test.repositories.MaterialRepository;
import LearningPeru.ing_software.test.service.CourseService;
import LearningPeru.ing_software.test.service.MaterialService;
import LearningPeru.ing_software.test.service.UploadsService;
import LearningPeru.ing_software.test.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    UserService userService;

    @Autowired
    UploadsService uploadsService;

    @Autowired
    CourseService courseService;

    @Autowired
    MaterialService materialService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    List<User> tester(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        User user= new User();
        user.setUsername("jbellido");
        user.setPassword(DigestUtils.sha256Hex("jbellido"));
        user.setName("Jesus");
        user.setLastname("Bellido");
        user.setType(Type_of_user.ADMIN);
        user.setSex(true);
        user.setCreated(new Date());
        System.out.println(user.getUsername());
        userService.save(user);

        User user2=new User();
        user2.setUsername("yserrano");
        user2.setPassword(DigestUtils.sha256Hex("yserrano"));
        user2.setName("Yamilet");
        user2.setLastname("Serrano");
        user2.setType(Type_of_user.CURATOR);
        user2.setSex(false);
        user2.setCreated(new Date());
        userService.save(user2);

        User user3=new User();
        user3.setUsername("josemaria");
        user3.setPassword(DigestUtils.sha256Hex("josemaria"));
        user3.setName("Jose");
        user3.setLastname("Maria");
        user3.setType(Type_of_user.TEACHER);
        user3.setSex(true);
        user3.setCreated(new Date());
        user3=userService.save(user3);

        User user4=new User();
        user4.setUsername("silvialabandera");
        user4.setPassword(DigestUtils.sha256Hex("silvialabandera"));
        user4.setName("Silvia");
        user4.setLastname("La bandera");
        user4.setType(Type_of_user.STUDENT);
        user4.setSex(false);
        user4.setCreated(new Date());
        userService.save(user4);

        User user5=new User();
        user5.setUsername("enrique");
        user5.setPassword(DigestUtils.sha256Hex("enrique"));
        user5.setName("Enrique");
        user5.setLastname("Sobrados");
        user5.setType(Type_of_user.TWAITING);
        user5.setSex(true);
        user5.setCreated(new Date());
        userService.save(user5);

        ////////IMPLEMENTACION ANTERIOR (no se si nos quedamos con esta porque tiene mas sentido
        Material material = new Material();
        Course course = new Course();

        course.setName("Matematica");
        course.setTheme("algebra_1");
        course.setGrade(1);
        course = courseService.SpecificSearch(course);
        List<Material> material_del_curso= course.getMateriales();

        Material material1= new Material();
        material1.setLearningPoints(419);
        material1.setStatus(2);
        material1.setRatingPeople(19);
        material1.setCourse(course);
        material1.setWho_posted(user3);
        material1.setName("ecuaciones1");
        material1.setDescription("ecuaciones basicas");

        Material material2= new Material();
        material2.setLearningPoints(500);
        material2.setStatus(2);
        material2.setRatingPeople(10);
        material2.setCourse(course);
        material2.setWho_posted(user3);
        material2.setName("polinomios");
        material2.setDescription("Polinomios de primer grado");

        Material material3= new Material();
        material3.setLearningPoints(777);
        material3.setRatingPeople(14);
        material3.setCourse(course);
        material3.setStatus(2);
        material3.setWho_posted(user3);
        material3.setName("funciones");
        material3.setDescription("funciones lineales");

        Material material4= new Material();
        material4.setLearningPoints(666);
        material4.setRatingPeople(17);
        material4.setStatus(1);
        material4.setCourse(course);
        material4.setWho_posted(user3);
        material4.setName("algebra lineal");
        material4.setDescription("matrices");

        material_del_curso.add(material1);
        material_del_curso.add(material2);
        material_del_curso.add(material3);
        material_del_curso.add(material4);
        course.setMateriales(material_del_curso);


        material.setCourse(course);
        material.setName("Test material");
        material.setDescription("Marcusss");
        material.setVisits(20);
        material.setDownloads(15);
        material.setRatingPeople(69);
        material.setLearningPoints(800);
        Date date = new Date();
        material.setDate(date);

        File file = new File();
        file.setName("Guia_Laboratorio_11_2");
        file.setDate(date);
        file.setLink("Guia_Laboratorio_11_2.pdf");
        file.setType(Type_of_file.PDF);

        File file2 = new File();
        file2.setName("link de youtube");
        file2.setDate(date);
        file2.setLink("https://www.youtube.com/embed/t3DpuQrBivU");
        file2.setType(Type_of_file.YOUTUBE_LINK);


        File file3 = new File();
        file3.setName("PRUEBA DE MP4");
        file3.setDate(date);
        file3.setLink("assets/prueba.mp4");
        file3.setType(Type_of_file.VIDEO);

        file.setMaterial_from(material);
        file2.setMaterial_from(material);
        file3.setMaterial_from(material);

        List<File> l = new ArrayList<>();
        l.add(file);
        l.add(file2);
        l.add(file3);
        material.setFiles(l);
        //josemaria
        material.setWho_posted(user3);

        List<Material> nuevoMaterial= new ArrayList<>();
        nuevoMaterial.add(material);
        user3.setMyMaterials(nuevoMaterial);
        material_del_curso.add(material);
        course.setMateriales(material_del_curso);
        courseService.save(course);
        userService.save(user3);

        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Material> getmateriales(){
        return materialService.getALL();
    }

}
