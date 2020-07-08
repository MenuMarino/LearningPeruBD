package LearningPeru.ing_software.test.repositories;

import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.Entity.Material;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MaterialRepository extends PagingAndSortingRepository<Material,Long> {

    @Query(value = "SELECT max(Id) FROM material",nativeQuery = true)
    Long maxID();

    List<Material> findAllByCourseAndStatus(Course course,Integer status, Pageable pageable);

}
