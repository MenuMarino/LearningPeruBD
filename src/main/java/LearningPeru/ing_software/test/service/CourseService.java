package LearningPeru.ing_software.test.service;

import LearningPeru.ing_software.test.Entity.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<Course> getAll();
}
