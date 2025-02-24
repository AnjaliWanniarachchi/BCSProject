package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Parent;
import com.bcs.project.stpauls.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    // Create or Update parent
    public Parent saveOrUpdateParent(Parent parent) {
        return parentRepository.save(parent);
    }

    // Get all parents
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    // Get parent by ID
    public Optional<Parent> getParentById(Long id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Invalid ID provided.");
        }
        System.out.println("trying to get parent with ID: " + id);
        Optional<Parent> parent = parentRepository.findById(id);
        System.out.println("Parent object" + parent);
        if (!parent.isPresent()) {
            return Optional.empty();  // Or throw a custom exception
        }
        return parent;
    }

    public Parent addParent(Parent parent) {
        if (parent.getParentId() != null && parentRepository.existsById(parent.getParentId())) {
            throw new IllegalArgumentException("Parent with ID already exists");
        }
        return parentRepository.save(parent);
    }

    // Delete parent by ID
    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }
}
