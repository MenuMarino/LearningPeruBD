package LearningPeru.ing_software.test.service;

import LearningPeru.ing_software.test.Entity.File;

import java.util.List;

public interface FileService {

    List<File> get_by_material(Long materialId);
}
