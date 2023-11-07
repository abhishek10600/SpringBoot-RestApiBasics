package com.RestApi.restapispringboot.controller;

import com.RestApi.restapispringboot.entities.Course;
import com.RestApi.restapispringboot.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    //testing
    @GetMapping("/home")
    public String home(){

        return "This is home page";
    }

    //get all the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.courseService.getCourses();
    }

    //get single course
    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //create a new course
    @PostMapping(path="/courses/add", consumes = "application/json")
    public Course createCourse(@RequestBody Course course){

        return this.courseService.addCourse(course);
    }

    //update a course
    @PutMapping(path="/course/{courseId}", consumes="application/json")
    public Course updateCourse(@PathVariable String courseId, @RequestBody Course course){
        return this.courseService.updateCourse(Long.parseLong(courseId), course);
    }

    //delete a course
    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
