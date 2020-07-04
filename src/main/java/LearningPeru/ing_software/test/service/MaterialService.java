package LearningPeru.ing_software.test.service;

import LearningPeru.ing_software.test.Entity.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getALL();

    Material save(Material material);

    Long get_max();

    Material find_by_id(Long Id );
}
