package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Batch;
import com.bcs.project.stpauls.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com")
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
        System.out.println("Fetching batch with ID: " + id);
        if (id == 0) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Batch> batch = batchService.getBatchById(id);
        return batch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Batch
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
            Optional<Batch> existingBatch = batchService.getBatchById(batch.getBatch_id());

            if (!existingBatch.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Batch updatedBatch = batchService.saveOrUpdateBatch(batch);

            return ResponseEntity.ok(updatedBatch);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
