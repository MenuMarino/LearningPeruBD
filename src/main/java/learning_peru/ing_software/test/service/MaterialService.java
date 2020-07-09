package learning_peru.ing_software.test.service;

import learning_peru.ing_software.test.entity.Course;
import learning_peru.ing_software.test.entity.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getALL();

    Material save(Material material);

    Long getMax();

    Material findById(Long Id );

    List<Material> getAllByCourse(Course course,Integer page);

    List<Material> getNotCuratedMaterials(Integer page);

}


