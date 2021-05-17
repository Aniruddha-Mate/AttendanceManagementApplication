package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.CourseEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.service.CourseService;

@CrossOrigin
@RestController
@RequestMapping("/Course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	//Add Course
	@PostMapping(path="/addCourse")
	public ResponseEntity<CourseEntity> addCourse(@Valid @RequestBody CourseEntity se)
	{
		CourseEntity se1 = courseService.addCourse(se);
		
		return ResponseEntity.ok(se1);
	}

	//Update Course by Id
	@PutMapping(path="/updateCourse/{courseId}")
	public ResponseEntity<CourseEntity> updateByCourseId(@Valid @PathVariable int courseId, @Valid @RequestBody CourseEntity entity) throws CourseIdNotFoundException
	{
		return ResponseEntity.ok(courseService.updateByCourseId(courseId,entity));
	}
	
	//Delete Course by Id
	@DeleteMapping(path="/deleteByCourseId/{courseId}")
	public ResponseEntity<String>deleteByCourseId(@Valid @PathVariable int courseId) throws RecordNotFoundException
	{
	      return ResponseEntity.ok(courseService.deleteByCourseId(courseId));
	}
	
	//Get All Course
	@GetMapping(path="/getAllCourse")
	public ResponseEntity<List<CourseEntity>> getCourse() throws RecordNotFoundException
	{
		return ResponseEntity.ok(courseService.getCourse());
	}
	
	//Get Course By Id
	@GetMapping(path="/getByCourseId/{courseId}")
	public ResponseEntity<CourseEntity> getCourseById(@Valid @PathVariable int courseId) throws CourseIdNotFoundException 
	{
		return ResponseEntity.ok(courseService.getCourseById(courseId));
	}
	
	@GetMapping(path="/getCourseByName/{courseName}") 
	  public ResponseEntity<List<CourseEntity>> findCourseByName(@PathVariable String courseName) 
			  throws RecordNotFoundException
	 {
		  List<CourseEntity> se=courseService.findCourseByName(courseName);
		  return ResponseEntity.ok(se);
		  
	 }
	

}
