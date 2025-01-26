package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Teacher;
import com.bcs.project.stpauls.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Create or Update teacher
    public Teacher saveOrUpdateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get teacher by ID
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher addTeacher(Teacher teacher) {
        if (teacher.getTeacher_id() != null && teacherRepository.existsById(teacher.getTeacher_id())) {
            throw new IllegalArgumentException("Teacher with ID already exists");
        }
        return teacherRepository.save(teacher);
    }

    // Delete teacher by ID
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
