package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.repositories.CourseRepository;
import LearningPeru.ing_software.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCourseService implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAll() {
        List<Course> temp= new ArrayList<>();
        for (Course course:courseRepository.findAll()){
            course.setMateriales(null);
            temp.add(course);
        }
        return temp;
    }

    @Override
    public List<Course> SpecificSearch( Course course) {
        return courseRepository.findAllByNameAndGradeAndTheme(course.getName(),course.getGrade(),course.getTheme());
    }
}

