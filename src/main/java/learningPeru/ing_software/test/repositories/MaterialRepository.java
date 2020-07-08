package learningPeru.ing_software.test.repositories;

import learningPeru.ing_software.test.Entity.Course;
import learningPeru.ing_software.test.Entity.Material;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MaterialRepository extends PagingAndSortingRepository<Material,Long> {

    @Query(value = "SELECT max(id) FROM material",nativeQuery = true)
    Long maxID();

    List<Material> findAllByCourseAndStatus(Course course,Integer status, Pageable pageable);

}
