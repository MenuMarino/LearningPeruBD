package learning_peru.ing_software.test.service.impl;

import learning_peru.ing_software.test.entity.Course;
import learning_peru.ing_software.test.repositories.CourseRepository;
import learning_peru.ing_software.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<String> getAllNames() {

        List<String> temp= new ArrayList<>();
        for (Course course:courseRepository.findAll()){
            if (!temp.contains(course.getName())){
                temp.add(course.getName());
            }
        }
        return temp;
    }

    @Override
    public Course specificSearch(Course course) {
        return courseRepository.findByNameAndGradeAndTheme(course.getName(),course.getGrade(),course.getTheme());
    }

    @Override
    public List<Course> getAll() {
        List<Course> temp= new ArrayList<>();
        for (Course course:courseRepository.findAll()){
            temp.add(course);
        }
        return temp;
    }

    @Override
    public List<String> getAllThemes(Course course) {

        List<String> temp= new ArrayList<>();
        for (Course curso:courseRepository.findAllByNameAndGrade(course.getName(),course.getGrade())){
            if (!temp.contains(curso.getTheme())){
                temp.add(curso.getTheme());
            }
        }
        return temp;
    }





}

