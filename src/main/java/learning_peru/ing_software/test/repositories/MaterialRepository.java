package learning_peru.ing_software.test.repositories;

import learning_peru.ing_software.test.entity.Course;
import learning_peru.ing_software.test.entity.Material;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MaterialRepository extends PagingAndSortingRepository<Material,Long> {

    @Query(value = "SELECT max(id) FROM material",nativeQuery = true)
    Long maxID();

    List<Material> findAllByCourseAndStatus(Course course,Integer status, Pageable pageable);

    List<Material> findAllByStatus(Integer status, Pageable pageable);

}
