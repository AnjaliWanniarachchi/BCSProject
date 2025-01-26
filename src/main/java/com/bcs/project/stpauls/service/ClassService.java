package com.bcs.project.stpauls.service;


import com.bcs.project.stpauls.model.Classes;
import com.bcs.project.stpauls.repository.ClassRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    // Create or Update class
    public Classes saveOrUpdateClass(Classes classes) {
        return classRepository.save(classes);
    }

    // Get all classes
    public List<Classes> getAllClasses() {
        return classRepository.findAll();
    }

    // Get class by ID
    public Optional<Classes> getClassById(Long id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Invalid ID provided.");
        }
        System.out.println("trying to get class with ID: " + id);
        Optional<Classes> classes = classRepository.findById(id);
        System.out.println("Class object" + classes);
        if (!classes.isPresent()) {
            return Optional.empty();  // Or throw a custom exception
        }
        return classes;
    }

    public Classes addClass(Classes classes) {
        if (classes.getClass_id() != null && classRepository.existsById(classes.getClass_id())) {
            throw new IllegalArgumentException("Class with ID already exists");
        }
        return classRepository.save(classes);
    }

    // Delete class by ID
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
