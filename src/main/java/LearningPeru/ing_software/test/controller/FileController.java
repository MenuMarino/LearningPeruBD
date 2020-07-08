package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.Beans.NewFileBean;
import LearningPeru.ing_software.test.Entity.File;
import LearningPeru.ing_software.test.Entity.Material;
import LearningPeru.ing_software.test.service.FileService;
import LearningPeru.ing_software.test.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    MaterialService materialService;


    @GetMapping
    @ResponseBody
    public List<File> getFilesFromMaterialId(@RequestParam("id") Long id){
        return fileService.get_by_material(id);
    }

    @PostMapping
    @ResponseBody
    public Boolean CreateFile(@RequestBody NewFileBean newFileBean){
        Material material = materialService.find_by_id(newFileBean.getMaterialId());
        List<File> files_list= material.getFiles();

        File file = new File();
        file.setType(newFileBean.getType_of_file());
        file.setName(newFileBean.getName());
        file.setLink(newFileBean.getLink());
        file.setDate(new Date());
        file.setMaterial_from(material);

        files_list.add(file);
        material.setFiles(files_list);
        materialService.save(material);
        return true;

    }

}
