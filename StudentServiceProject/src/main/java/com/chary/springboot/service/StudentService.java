package com.chary.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.springboot.entities.Student;
import com.chary.springboot.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student getStudentById(int id)
	{
		return studentRepository.findById(id).get();
	}
	
	public Student insertStudent(Student student)
	{
		return studentRepository.save(student);
	}

}
