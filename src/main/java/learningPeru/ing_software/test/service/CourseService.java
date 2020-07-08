package learningPeru.ing_software.test.service;

import learningPeru.ing_software.test.Entity.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<String> getAllNames();

    Course SpecificSearch(Course course);


    List<Course> getAll();

    List<String> getAllThemes(Course course);

}
