package LearningPeru.ing_software.test.repositories;

import LearningPeru.ing_software.test.Entity.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaterialRepository extends CrudRepository<Material,Long> {

}
