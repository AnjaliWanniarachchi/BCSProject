package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Classes;
import com.bcs.project.stpauls.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com")
@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    // Create or Update Class
    @PostMapping("/save-class")
    public ResponseEntity<Classes> saveClass(@RequestBody Classes classes) {
        return ResponseEntity.ok(classService.saveOrUpdateClass(classes));
    }

    // Get all Classes
    @GetMapping("/classes")
    public List<Classes> getAllClasses() {
        return classService.getAllClasses();
    }

    // Get Class by ID
    @GetMapping("/get-class/{id}")
    public ResponseEntity<Classes> getClassById(@PathVariable Long id) {
        System.out.println("Fetching class with ID: " + id);
        if (id == 0) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Classes> classes = classService.getClassById(id);
        return classes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Class
    @PostMapping("/add-class")
    public ResponseEntity<Classes> addClass(@RequestBody Classes classes) {
        try {
            return ResponseEntity.ok(classService.addClass(classes));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Class by ID
    @DeleteMapping("/delete-class/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit-class")
    public ResponseEntity<Classes> editClass(@RequestBody Classes classes) {
        try {
            Optional<Classes> existingClass = classService.getClassById(classes.getClass_id());

            if (!existingClass.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Classes updatedClass = classService.saveOrUpdateClass(classes);

            return ResponseEntity.ok(updatedClass);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
