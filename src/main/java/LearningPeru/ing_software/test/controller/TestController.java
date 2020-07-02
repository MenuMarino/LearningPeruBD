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

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/test")
public class TestController {
    private String path="/home/lushop/Desktop/software/LearningPBD_CESAR/src/main/java/LearningPeru/ing_software/test/userFiles/";

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
        userService.save(user3);

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

        Material material = new Material();
        Course course = new Course();
        course.setId((long) 1);
        course.setName("Matematica");
        course.setTheme("Vectores");
        course = courseService.save(course);
        material.setId((long) 1);
        material.setCourse(course);
        material.setName("Test material");
        material.setDescription("Marcusss");
        material.setVisits(20);
        material.setDownloads(15);
        material.setRatingPeople(69);
        Date date = new Date();
        material.setDate(date);
        File file = new File();
        file.setId((long) 1);
        file.setDate(date);
        file.setLink("facebook.com");
        List<File> l = new ArrayList<>();
        l.add(file);
        material.setFiles(l);

        //josemaria
        material.setWho_posted(user3);

        List<Material> nuevoMaterial= new ArrayList<>();
        nuevoMaterial.add(material);
        user3.setMyMaterials(nuevoMaterial);

        userService.save(user3);

        return userService.getAll();
        //Crear un material
    }

    @PostMapping(value="/uploads/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    HttpEntity<Boolean> upload(@RequestParam("file") MultipartFile file, @PathVariable("id") Integer id) throws IOException {
        String aux = path;
        path = path + id + "/upgrade_files/";
        uploadsService.save(path,file);
        path = aux;
        //return uploadsService.download("application/png",path+file.getOriginalFilename());
        HttpHeaders headers= new HttpHeaders();
        headers.add("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        headers.add("Access-Control-Allow-Headers", "X-Requested-With, X-Auth-Token");
        headers.add("Access-Control-Allow-Credentials", "true");
        return new ResponseEntity<>(true,headers, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Material> getmateriales(){
        return materialService.getALL();
    }

}
