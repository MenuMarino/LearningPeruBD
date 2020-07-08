package learningPeru.ing_software.test.service;

import learningPeru.ing_software.test.Entity.Course;
import learningPeru.ing_software.test.Entity.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getALL();

    Material save(Material material);

    Long get_max();

    Material find_by_id(Long Id );

    List<Material> getAllByCourse(Course course,Integer page);
}
