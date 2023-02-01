package com.chary.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chary.springboot.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
