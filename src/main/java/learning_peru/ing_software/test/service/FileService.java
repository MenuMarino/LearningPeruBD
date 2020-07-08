package learning_peru.ing_software.test.service;

import learning_peru.ing_software.test.entity.File;

import java.util.List;

public interface FileService {

    List<File> getByMaterial(Long materialId);
}
