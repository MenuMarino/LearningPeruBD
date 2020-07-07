package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Entity.File;
import LearningPeru.ing_software.test.service.FileService;
import LearningPeru.ing_software.test.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping
    @ResponseBody
    List<File> getFilesFromMaterialId(@RequestParam("id") Long id){
        return fileService.get_by_material(id);
    }

}
