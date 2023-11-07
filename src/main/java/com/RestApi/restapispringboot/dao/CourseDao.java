package com.RestApi.restapispringboot.dao;

import com.RestApi.restapispringboot.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Long> {

}
