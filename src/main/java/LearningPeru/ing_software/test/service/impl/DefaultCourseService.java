package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.repositories.CourseRepository;
import LearningPeru.ing_software.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCourseService implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
