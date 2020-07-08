package learningPeru.ing_software.test.service;

import learningPeru.ing_software.test.Entity.File;

import java.util.List;

public interface FileService {

    List<File> get_by_material(Long materialId);
}
