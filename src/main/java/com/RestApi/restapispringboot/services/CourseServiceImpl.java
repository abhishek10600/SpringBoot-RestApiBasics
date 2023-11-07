package com.RestApi.restapispringboot.services;

import com.RestApi.restapispringboot.dao.CourseDao;
import com.RestApi.restapispringboot.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl(){
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId){
        Optional<Course> course = courseDao.findById(courseId);
        return course.get();
    }

    @Override
    public Course addCourse(Course course){
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        courseDao.deleteById(courseId);
    }

    @Override
    public Course updateCourse(long courseId, Course course) {
        Optional<Course> c = courseDao.findById(courseId);
        if(c.isPresent()){
            Course updateCourse = c.get();
            updateCourse.setTitle(course.getTitle());
            updateCourse.setDescription(course.getDescription());
            courseDao.save(updateCourse);
            return updateCourse;
        }
        return null;
    }
}
