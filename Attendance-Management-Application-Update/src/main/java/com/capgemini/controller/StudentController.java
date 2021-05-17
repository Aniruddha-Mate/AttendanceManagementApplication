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

import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;
import com.capgemini.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService studService;
	
	@GetMapping("/students/{studentId}")
	public ResponseEntity<StudentEntity> getStudentById(@Valid @PathVariable int studentId) throws StudentNotFoundException
	{
		
		return  ResponseEntity.ok(studService.getStudentById(studentId));
	}
	@GetMapping("/students")
	public ResponseEntity<List<StudentEntity>> getStudents() throws RecordNotFoundException
	{
		return ResponseEntity.ok(studService.getStudents());
	}
	
	@PutMapping("/update/{studentId}")
	public ResponseEntity<StudentEntity> updateStudent(@Valid @RequestBody StudentEntity entity) 
			throws StudentNotFoundException
	{
		return  ResponseEntity.ok(studService.updateStudent(entity));
	}
	

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@Valid @PathVariable int studentId) throws RecordNotFoundException
	{
		return ResponseEntity.ok(studService.deleteStudent(studentId));
	}

	@PostMapping("/addStudentwithCourse")
	public ResponseEntity<StudentEntity> addStudentwithC(@Valid @RequestBody StudentEntity entity)
			throws CourseIdNotFoundException, DuplicateRecordException
	{
		return ResponseEntity.ok(studService.addStudentwithC(entity));
	}
	
	@GetMapping("/getStudentByFirstName/{firstName}")
	public ResponseEntity<List<StudentEntity>> getStudentByFirstName(@Valid @PathVariable String firstName) throws StudentNotFoundException
	{
		return new ResponseEntity<List<StudentEntity>>(studService.findStudentByFirstName(firstName),HttpStatus.FOUND);
	}
	
	@GetMapping("/getStudentByFirstNameAndLastName/{firstName}/{lastName}")
	public ResponseEntity<List<StudentEntity>> getStudentByFirstName(@Valid @PathVariable String firstName, @Valid @PathVariable String lastName) 
			throws StudentNotFoundException
	{
		return new ResponseEntity<List<StudentEntity>>(studService.findStudentByFirstNameAndLastName(firstName,lastName),HttpStatus.FOUND);
	}
	

}
