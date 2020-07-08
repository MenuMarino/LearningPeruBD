package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.beans.NewFileBean;
import learning_peru.ing_software.test.entity.File;
import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.service.FileService;
import learning_peru.ing_software.test.service.MaterialService;
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
        return fileService.getByMaterial(id);
    }

    @PostMapping
    @ResponseBody
    public Boolean createFile(@RequestBody NewFileBean newFileBean){
        Material material = materialService.findById(newFileBean.getMaterialId());
        List<File> fileList= material.getFiles();

        File file = new File();
        file.setType(newFileBean.getTypeOfFile());
        file.setName(newFileBean.getName());
        file.setLink(newFileBean.getLink());
        file.setDate(new Date());
        file.setMaterialFrom(material);

        fileList.add(file);
        material.setFiles(fileList);
        materialService.save(material);
        return true;

    }

}
