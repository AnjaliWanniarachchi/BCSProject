package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Batch;
import com.bcs.project.stpauls.model.Batch;
import com.bcs.project.stpauls.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BatchController {

    @Autowired
    private BatchService batchService;

    // Create or Update Batch
    @PostMapping("/save-batch")
    public ResponseEntity<Batch> saveBatch(@RequestBody Batch batch) {
        return ResponseEntity.ok(batchService.saveOrUpdateBatch(batch));
    }

    // Get all Batches
    @GetMapping("/batches")
    public List<Batch> getAllBatches() {
        return batchService.getAllBatches();
    }

    // Get Batch by ID
    @GetMapping("/get-batch/{id}")
    public ResponseEntity<Batch> getBatchById(@PathVariable Long id) {
        Optional<Batch> batch = batchService.getBatchById(id);
        return batch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Batch (exclusive)
    @PostMapping("/add-batch")
    public ResponseEntity<Batch> addBatch(@RequestBody Batch batch) {
        try {
            return ResponseEntity.ok(batchService.addBatch(batch));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Batch by ID
    @DeleteMapping("/delete-batch/{id}")
    public ResponseEntity<Void> deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit-batch")
    public ResponseEntity<Batch> editBatch(@RequestBody Batch batch) {
        try {
            // Check if the batch exists by ID
            Optional<Batch> existingBatch = batchService.getBatchById(batch.getBatch_id());

            if (!existingBatch.isPresent()) {
                // Return a 404 if the batch doesn't exist
                return ResponseEntity.notFound().build();
            }

            // Update the batch information
            Batch updatedBatch = batchService.saveOrUpdateBatch(batch);

            // Return the updated batch
            return ResponseEntity.ok(updatedBatch);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
