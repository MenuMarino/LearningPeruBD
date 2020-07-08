package learningPeru.ing_software.test.service.impl;

import learningPeru.ing_software.test.Entity.File;
import learningPeru.ing_software.test.Entity.Material;
import learningPeru.ing_software.test.service.FileService;
import learningPeru.ing_software.test.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFileService implements FileService {

    @Autowired
    MaterialService materialService;

    @Override
    public List<File> get_by_material(Long materialId) {
        Material material= materialService.find_by_id(materialId);
        return material.getFiles();
    }
}
