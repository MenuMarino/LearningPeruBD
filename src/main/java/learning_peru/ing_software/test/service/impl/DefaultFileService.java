package learning_peru.ing_software.test.service.impl;

import learning_peru.ing_software.test.entity.File;
import learning_peru.ing_software.test.entity.Material;
import learning_peru.ing_software.test.service.FileService;
import learning_peru.ing_software.test.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFileService implements FileService {

    @Autowired
    MaterialService materialService;

    @Override
    public List<File> getByMaterial(Long materialId) {
        Material material= materialService.findById(materialId);
        return material.getFiles();
    }
}
