package learning_peru.ing_software.test.service;

import learning_peru.ing_software.test.entity.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<String> getAllNames();

    Course specificSearch(Course course);


    List<Course> getAll();

    List<String> getAllThemes(Course course);

}
