package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Student;
import com.bcs.project.stpauls.model.Teacher;
import com.bcs.project.stpauls.service.StudentService;
import com.bcs.project.stpauls.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create or Update Student
    @PostMapping("/save-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveOrUpdateStudent(student));
    }

    // Get all Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student by ID
    @GetMapping("/get-student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Student (exclusive)
    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            return ResponseEntity.ok(studentService.addStudent(student));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Student by ID
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
