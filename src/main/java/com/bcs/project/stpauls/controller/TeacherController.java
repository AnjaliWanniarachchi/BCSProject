package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Teacher;
import com.bcs.project.stpauls.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save-teacher")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.saveOrUpdateTeacher(teacher));
    }

    // Get all Teachers
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    // Get Teacher by ID
    @GetMapping("/get-teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Teacher (exclusive)
    @PostMapping("/add-teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        try {
            return ResponseEntity.ok(teacherService.addTeacher(teacher));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Teacher by ID
    @DeleteMapping("/delete-teacher/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

}
