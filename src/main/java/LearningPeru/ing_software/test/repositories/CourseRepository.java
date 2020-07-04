package LearningPeru.ing_software.test.repositories;


import LearningPeru.ing_software.test.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {

    List<Course> findAllByNameAndGradeAndTheme(String name,Integer grade,String theme);

    List<Course> findAllByNameAndGrade(String name,Integer grade);

    Page<Course> findAllByNameAndGradeAndTheme(String name,Integer grade,String theme,Pageable pageable);
}
