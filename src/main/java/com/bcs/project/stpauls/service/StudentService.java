package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Student;
import com.bcs.project.stpauls.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create or Update student
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        if (student.getStudent_id() != null && studentRepository.existsById(student.getStudent_id())) {
            throw new IllegalArgumentException("Student with ID already exists");
        }
        return studentRepository.save(student);
    }

    // Delete student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
