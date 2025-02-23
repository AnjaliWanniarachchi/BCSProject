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

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com:4200")
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
        System.out.println("Fetching student with ID: " + id);
        if (id == 0) {
            return ResponseEntity.badRequest().body(null);  // Prevent fetching with an invalid ID
        }

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

    @PutMapping("/edit-student")
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        try {
            // Check if the student exists by ID
            Optional<Student> existingStudent = studentService.getStudentById(student.getStudentId());

            if (!existingStudent.isPresent()) {
                // Return a 404 if the student doesn't exist
                return ResponseEntity.notFound().build();
            }

            // Update the student information
            Student updatedStudent = studentService.saveOrUpdateStudent(student);

            // Return the updated student
            return ResponseEntity.ok(updatedStudent);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
