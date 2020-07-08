package learningPeru.ing_software.test.repositories;


import learningPeru.ing_software.test.Entity.Course;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {


    List<Course> findAllByNameAndGrade(String name,Integer grade);

    Course findByNameAndGradeAndTheme(String name, Integer grade, String theme);
}
