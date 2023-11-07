package com.RestApi.restapispringboot.services;
import com.RestApi.restapispringboot.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public void deleteCourse(long courseId);

    public Course updateCourse(long courseId, Course course);
}
