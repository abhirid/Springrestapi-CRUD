package com.example.restapi.controller;

import com.example.restapi.entity.Student;
import com.example.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student>students =repo.findAll();
        return students;
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
       return repo.findById(id).get();

    }
    @PostMapping("/student/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);

    }
    @PutMapping("/student/update/{id}")
    public Student updateStudents(@PathVariable int id){
        Student student=repo.findById(id).get();
        student.setName("Rinku");
        student.setPercentage(77);
        repo.save(student);
        return student;

    }
    @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id){
      Student student=repo.findById(id).get();
        repo.delete(student);
    }

}
