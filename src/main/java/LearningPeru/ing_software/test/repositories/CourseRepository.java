package LearningPeru.ing_software.test.repositories;


import LearningPeru.ing_software.test.Entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Long> {
    List<Course> findAllByNameAndGradeAndTheme(String name,Integer grade,String theme);
}
