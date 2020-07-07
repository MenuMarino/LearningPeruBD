package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.Entity.File;
import LearningPeru.ing_software.test.Entity.Material;
import LearningPeru.ing_software.test.service.FileService;
import LearningPeru.ing_software.test.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultFileService implements FileService {

    @Autowired
    MaterialService materialService;

    @Override
    public List<File> get_by_material(Long materialId) {
        Material material= materialService.find_by_id(materialId);
        return material.getFiles();
    }
}
