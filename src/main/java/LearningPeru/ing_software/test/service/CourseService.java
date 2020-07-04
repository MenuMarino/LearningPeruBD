package LearningPeru.ing_software.test.service;

import LearningPeru.ing_software.test.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<String> getAllNames();

    Course SpecificSearch(Course course);


    List<Course> getAll();

    List<String> getAllThemes(Course course);

    //List<Course> SpecificSearch2(Course course);
}
