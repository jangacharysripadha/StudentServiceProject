package com.chary.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chary.springboot.entities.Library;
import com.chary.springboot.entities.Student;
import com.chary.springboot.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		Library library=restTemplate.getForObject("http://localhost:9092/api/library/"+id, Library.class);
		Student student=studentService.getStudentById(id);
		student.setLibrary(library);
		return student;
		//return studentService.getStudentById(id);
	}

	@PostMapping("/insert")
	public Student inserStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
}
