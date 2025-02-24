package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Parent;
import com.bcs.project.stpauls.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ParentController {

    @Autowired
    private ParentService parentService;

    // Create or Update Parent
    @PostMapping("/save-parent")
    public ResponseEntity<Parent> saveParent(@RequestBody Parent parent) {
        return ResponseEntity.ok(parentService.saveOrUpdateParent(parent));
    }

    // Get all Parents
    @GetMapping("/parents")
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    // Get Parent by ID
    @GetMapping("/get-parent/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        System.out.println("Fetching parent with ID: " + id);
        if (id == 0) {
            return ResponseEntity.badRequest().body(null);  // Prevent fetching with an invalid ID
        }

        Optional<Parent> parent = parentService.getParentById(id);
        return parent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Parent
    @PostMapping("/add-parent")
    public ResponseEntity<Parent> addParent(@RequestBody Parent parent) {
        try {
            return ResponseEntity.ok(parentService.addParent(parent));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Parent by ID
    @DeleteMapping("/delete-parent/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit-parent")
    public ResponseEntity<Parent> editParent(@RequestBody Parent parent) {
        try {
            Optional<Parent> existingParent = parentService.getParentById(parent.getParentId());

            if (!existingParent.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Parent updatedParent = parentService.saveOrUpdateParent(parent);

            return ResponseEntity.ok(updatedParent);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
